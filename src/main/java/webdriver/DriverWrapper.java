package webdriver;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class DriverWrapper {
    public WebDriver driver = null;

    public WebDriver getDriver() {
                this.driver = DriverFactory.createDriver();
                this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                return this.driver;
        }
    }