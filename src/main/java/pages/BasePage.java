package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForElement(WebElement element) {
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(element),
                    ExpectedConditions.elementToBeClickable(element)
            ));
            return element;
    }

    protected WebElement clickElement(WebElement element) {
            waitForElement(element);
            element.click();
        return element;
    }
    protected void sendText(WebElement element, String text) {
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementDisplayed(WebElement element,  long timeoutSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until((ExpectedCondition<Boolean>)
                    driver -> (element.isDisplayed()));
        }
        catch (Exception e) {
            return false;
        }
    }
    protected void alertWait() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public String getAlertMessage() {
        alertWait();
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert() {
        alertWait();
        driver.switchTo().alert().accept();
    }
}
