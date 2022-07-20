package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutButton = By.id("checkout");
    private By addedProduct = By.className("inventory_item_name");

    public WebElement checkAddedProduct() {
        return driver.findElement(addedProduct);
    }

    public void goToCheckout() {
        driver.findElement(checkoutButton).click();
    }

}
