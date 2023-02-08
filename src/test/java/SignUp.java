import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import webdriver.DriverWrapper;

public class SignUp extends BaseTest{
    HomePage homePage;
    SignUpPage signUpPage;
    @BeforeMethod()
    public void setUp() {
        driver = new DriverWrapper().getDriver();
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        driver.get(URL);
    }

    @Test
    public void validSingUp() {
        homePage.clickSignUpBtn();
        signUpPage.signUp(randTextWithNum("Test"), "Test123");
        signUpPage.verifyAlertMessageSuccessfulSignup();
    }

    @Test
    public void singUpWithUsedUsername() {
        homePage.clickSignUpBtn();
        signUpPage.signUp("Miljan", "1234");
        signUpPage.verifyAlertMessageUsedUser();

    }

    @Test
    public void singUpWithEmptyFields() {
        homePage.clickSignUpBtn();
        signUpPage.signUp("", "");
        signUpPage.verifyAlertEmptyUser();
    }
}
