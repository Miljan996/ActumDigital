import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import webdriver.DriverWrapper;

public class AddToCart extends BaseTest {
    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod()
    public void setUp() {
        driver = new DriverWrapper().getDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        driver.get(URL);
    }

    @Test
    public void addingPhoneToCart() {
        homePage.clickOnNokiaLumia();
        productPage.verifyPhoneIsAddedToCart();
        productPage.clickOnAddToCart();
        productPage.verifyAlertMessageProductAdded();
    }

    @Test
    public void addingLaptopToCart() {
        homePage.clickOnLaptops();
        homePage.clickOnMacBookAir();
        productPage.verifyLaptopIsAddedToCart();
        productPage.clickOnAddToCart();
        productPage.verifyAlertMessageProductAdded();
    }
}
