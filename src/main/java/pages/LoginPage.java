package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
    }
    HomePage homePage;
    @FindBy(id = "loginusername")
    WebElement inp_UsernameLogin;

    @FindBy(id = "loginpassword")
    WebElement inp_PasswordLogin;
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement buttonLogin;

    @FindBy(xpath = "(//button[contains(text(),'Close')])[3]")
    WebElement buttonClose;

    public LoginPage login(String username, String password) {
        sendText(inp_UsernameLogin, username);
        sendText(inp_PasswordLogin, password);
        clickElement(buttonLogin);
        return new LoginPage(driver);
    }

    public void verifyAlertMessageEmpty(){
        Assert.assertEquals(getAlertMessage(), "Please fill out Username and Password.");
        acceptAlert();
    }

    public void verifyAlertMessageInvalidPass(){
        Assert.assertEquals(getAlertMessage(), "Wrong password.");
        acceptAlert();
    }

    public void verifyAlertMessageInvalidUser(){
        Assert.assertEquals(getAlertMessage(), "User does not exist.");
        acceptAlert();
    }

}
