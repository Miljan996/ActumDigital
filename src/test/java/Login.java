import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import webdriver.DriverWrapper;

public class Login extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    @BeforeMethod()
    public void setUp() {
        driver = new DriverWrapper().getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://www.demoblaze.com/");
    }
    @Test
    public void loginWithEmptyFields() {
        homePage.clickLoginBtn()
                .login("", "")
                .verifyAlertMessageEmpty();
    }

    @Test
    public void loginWithValidUsernameAndInvalidPassword() {
        homePage.clickLoginBtn()
                .login("Miljan", randTextWithNum("Test"))
                .verifyAlertMessageInvalidPass();
    }

    @Test
    public void loginWithInvalidUsername() {
        homePage.clickLoginBtn()
                .login(randTextWithNum("User"), "1111")
                .verifyAlertMessageInvalidUser();
    }

    @Test
    public void validLogin() {
        homePage.clickLoginBtn()
                .login("Miljan", "1234") ;
                homePage.verifyIfWelcomeIsPresent();
    }

    @Test
    public void logout() {
        homePage.clickLoginBtn()
                .login("Miljan", "1234") ;
        homePage.verifyIfWelcomeIsPresent();
        homePage.clickLogoutBtn();
        homePage.verifyIfLoginIsDisplayed();
    }
}