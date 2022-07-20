package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    private WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutComplete = By.className("title");
    private By thanksForOrder = By.className("complete-header");
    private By backHomeButton = By.id("back-to-products");

    public WebElement checkComplete() {
        return driver.findElement(checkoutComplete);
    }

    public WebElement checkThanks() {
        return driver.findElement(thanksForOrder);
    }

    public void backHome() {
        driver.findElement(backHomeButton).click();
    }

}
