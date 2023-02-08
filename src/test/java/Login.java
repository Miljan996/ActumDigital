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
        driver.get(URL);
    }
    @Test
    public void loginWithEmptyFields() {
        homePage.clickLoginBtn();
        loginPage.login("", "");
        loginPage.verifyAlertMessageEmpty();
    }

    @Test
    public void loginWithValidUsernameAndInvalidPassword() {
        homePage.clickLoginBtn();
        loginPage.login("Miljan", randTextWithNum("Test"));
        loginPage.verifyAlertMessageInvalidPass();
    }

    @Test
    public void loginWithInvalidUsername() {
        homePage.clickLoginBtn();
        loginPage.login(randTextWithNum("User"), "1111");
        loginPage.verifyAlertMessageInvalidUser();
    }

    @Test
    public void validLogin() {
        homePage.clickLoginBtn();
        loginPage.login("Miljan", "1234") ;
        homePage.verifyIfWelcomeIsPresent();
    }

    @Test
    public void logout() {
        homePage.clickLoginBtn();
        loginPage.login("Miljan", "1234") ;
        homePage.verifyIfWelcomeIsPresent();
        homePage.clickLogoutBtn();
        homePage.verifyIfLoginIsDisplayed();
    }
}