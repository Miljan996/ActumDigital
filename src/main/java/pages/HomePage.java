package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
    }

    @FindBy(id = "login2")
    protected WebElement link_Login;
    @FindBy(xpath = "//button[text()='Log in']")
    protected WebElement btn_Login;
    @FindBy(xpath = "//a[text()='Welcome Miljan']")
    protected WebElement txt_Welcome;
    @FindBy(id = "logout2")
    protected WebElement btn_Logout;
    @FindBy(id = "signin2")
    WebElement link_SignUp;
    @FindBy(linkText = "Phones")
    WebElement linkPhones;
    @FindBy(linkText = "Laptops")
    WebElement linkLaptops;
    @FindBy(linkText = "Monitors")
    WebElement linkMonitors;
    @FindBy(linkText = "Nokia lumia 1520")
    WebElement linkNokiaLumia1520;
    @FindBy(linkText = "MacBook air")
    WebElement linkMacBookAir;
    @FindBy(id = "cartur")
    WebElement linkCart;

    public LoginPage clickLoginBtn () {
        clickElement(link_Login);
        return new LoginPage(driver);
    }

    public LoginPage clickLogoutBtn () {
        clickElement(btn_Logout);
        return new LoginPage(driver);
    }

    public HomePage verifyIfWelcomeIsPresent(){
        isElementDisplayed(txt_Welcome, 5);
        return new HomePage(driver);
    }
    public HomePage verifyIfLoginIsDisplayed(){
        isElementDisplayed(link_Login, 5);
        return new HomePage(driver);
    }

    public HomePage clickSignUpBtn () {
        clickElement(link_SignUp);
        return new HomePage(driver);
    }
    public void clickOnPhones() {
        clickElement(linkPhones);
    }
    public ProductPage clickOnNokiaLumia() {
        clickElement(linkNokiaLumia1520);
        return new ProductPage(driver);
    }
    public void clickOnLaptops() {
        clickElement(linkLaptops);
    }
    public ProductPage clickOnMacBookAir() {
        clickElement(linkMacBookAir);
        return new ProductPage(driver);
    }

    public HomePage clickOnCart() {
        clickElement(linkCart);
        return new HomePage(driver);
    }
}
