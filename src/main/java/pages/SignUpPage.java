package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
    }
    @FindBy(id = "sign-username")
    WebElement inputTextUsername;
    @FindBy(id = "sign-password")
    WebElement inputTextPassword;
    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement buttonSignUp;
    @FindBy(xpath = "(//button[contains(text(),'Close')])[2]")
    WebElement buttonClose;
    @FindBy(xpath = "(//span[text()='×'])[2]")
    WebElement buttonX;

    public void signUp(String username, String password) {
        sendText(inputTextUsername, username);
        sendText(inputTextPassword, password);
        clickElement(buttonSignUp);
    }

    public void closeSignUpPage(){
        clickElement(buttonClose);
    }
    public void closeSignUpPageUsingX(){
        clickElement(buttonX);
    }
    public void verifyAlertMessageSuccessfulSignup(){
        Assert.assertEquals(getAlertMessage(), "Sign up successful.");
        acceptAlert();
    }
    public void verifyAlertMessageUsedUser(){
        Assert.assertEquals(getAlertMessage(), "This user already exist.");
        acceptAlert();
    }
    public void verifyAlertEmptyUser(){
        Assert.assertEquals(getAlertMessage(), "Please fill out Username and Password.");
        acceptAlert();
    }
}
