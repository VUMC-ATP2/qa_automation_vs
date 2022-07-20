package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String INVENTORY_PAGE = "https://www.saucedemo.com/inventory.html";

    private By sauceLabsBackpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By goToCartButton = By.className("shopping_cart_link");

    public void sauceLabsBackpackToCart() {
        driver.findElement(sauceLabsBackpackAddToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(goToCartButton).click();
    }


}
