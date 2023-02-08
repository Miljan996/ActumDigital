package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class DriverFactory {
    public static WebDriver createDriver()  {

        RemoteWebDriver driver = null;

                if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.chrome.driver", getProjectRootDir() + "src/main/java/driver/chromedriver.exe");
                } else {
                    System.setProperty("webdriver.chrome.driver", getProjectRootDir() + "src/main/java/driver/chromedriver");
                }

                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
    }

    public static String getProjectRootDir() {
        String path = (new File(".")).getAbsolutePath();
        return path.replace(System.getProperty("file.separator") + ".", System.getProperty("file.separator"));
    }
}