import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import webdriver.DriverWrapper;

public class DeletingProduct extends BaseTest {
    HomePage homePage;
    CartPage cartPage;
    ProductPage productPage;
    @BeforeMethod()
    public void setUp() {
        driver = new DriverWrapper().getDriver();
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        driver.get("https://www.demoblaze.com/");
    }

    @Test
    public void cartDelete() {
        homePage.clickOnNokiaLumia();
        productPage.verifyPhoneIsAddedToCart();
        productPage.clickOnAddToCart();
        productPage.verifyAlertMessageProductAdded();
        homePage.clickOnCart();
        cartPage.deleteProduct();
        cartPage.isProductDeleted();
    }
}
