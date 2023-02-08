package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
    }

    @FindBy(className = "name")
    WebElement tagProductName;
    @FindBy(linkText = "Add to cart")
    WebElement linkAddToCart;

    public void clickOnAddToCart() {
        clickElement(linkAddToCart);
    }
    public String getProductTagName() { return tagProductName.getText(); }

    public void verifyPhoneIsAddedToCart(){
        Assert.assertEquals(getProductTagName(), "Nokia lumia 1520");
    }
    public void verifyAlertMessageProductAdded(){
        Assert.assertEquals(getAlertMessage(), "Product added");
        acceptAlert();
    }
    public void verifyLaptopIsAddedToCart(){
        Assert.assertEquals(getProductTagName(), "MacBook air");
    }
}
