import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import java.net.URL;
import java.util.Random;


public class BaseTest {
    static WebDriver driver;
    public static final String URL = "https://www.demoblaze.com/";


    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    public String randTextWithNum(String randText) {
        Random rand = new Random();
        String randName = randText + rand.nextInt(10000);
        return randName;
    }

}
