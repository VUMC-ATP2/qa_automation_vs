package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addedProductName = By.className("inventory_item_name");
    private By addedProductPrice = By.className("inventory_item_price");
    private By finishButton = By.id("finish");

    public WebElement checkProductName() {
        return driver.findElement(addedProductName);

    }

    public WebElement checkProductPrice() {
        return driver.findElement(addedProductPrice);
    }

    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }

}