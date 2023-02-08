package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
    }
    Random random = new Random();
    int numOfProducts;
    int totalPrice = 0;


    @FindBy(linkText = "Delete")
    List<WebElement> linkDelete;
    @FindBy(id = "totalp")
    WebElement textTotalPrice;
    @FindBy(xpath = "//tr[@class='success']/td[3]")
    List<WebElement> textPrice;

    public void deleteProduct() {
        numOfProducts = linkDelete.size();
        int index = random.nextInt(numOfProducts);
        totalPrice -= Integer.parseInt(textPrice.get(index).getText());
        clickElement(linkDelete.get(index));
    }

    public boolean isProductDeleted() {
        return numOfProducts > linkDelete.size();
    }

}
