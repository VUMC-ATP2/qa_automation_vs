package seleniumHomework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

public class sauceDemoTests {

    private final String LOGIN_PAGE = "https://www.saucedemo.com/";
    private final String INVENTORY_PAGE = "https://www.saucedemo.com/inventory.html";
    private final String CART_PAGE = "https://www.saucedemo.com/cart.html";
    private final String PASSWORD = "secret_sauce";
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @BeforeMethod
    public void newOpenBrowser() {
        this.driver = new ChromeDriver();
        driver.get(LOGIN_PAGE);
    }
    /*
    @AfterMethod (alwaysRun = true)
    public void closeBrowser () {
        driver.close();
        driver.quit();
    }

     */


    // 1 SCENARIO
  /*
1. Navigēt uz saiti https://www.saucedemo.com/
2. Ielogoties ar pareizu lietotāja vārdu/paroli
3. Pārbaudīt, ka lietotājs ir ielogojies
4. Ievietot Grozā 1 produktu
5. Doties uz grozu
6. Pārbaudīt, kā šī prece ir grozā ??
7. Doties uz Checkout
8. Ievadīt vārdu/uzvārdu/pasta indeksu
9. Doties uz Checkout overview lapu, pārbaudīt datus
10. Doties uz finish lapu un pārbaudīt vai viss bija veiksmīgi
11. Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'
*/

    @Test
    public void scenarioOneTest() {
        loginPage = new LoginPage(driver);
        loginPage.LogOn("standard_user", PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), INVENTORY_PAGE);
        inventoryPage = new InventoryPage(driver);
        inventoryPage.sauceLabsBackpackToCart();
        inventoryPage.goToCart();
        cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.checkAddedProduct().getText(), "Sauce Labs Backpack");
        cartPage.goToCheckout();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillYourInformation("John", "Watson", "NW1 6XE");
        checkoutPage.continueCheckout();
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.checkProductName().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(checkoutOverviewPage.checkProductPrice().getText(), "$29.99");
        checkoutOverviewPage.finishCheckout();
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.checkComplete().getText(), "CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.checkThanks().getText(), "THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.backHome();
    }

    // 2 SCENARIO
    /*
1. Navigēt uz saiti https://www.saucedemo.com/
2. Ielogoties ar pareizu lietotāja vārdu/paroli
3. Doties uz grozu
4. Doties uz Checkout
5. Pārbaudīt, ka FirstName/LastName/Zip code ir obligāts
6. Pārbaudīt, ka forma parāda pareizu kļūdas paziņojumu pie katra neievadītā lauka
     */

    @Test
    public void scenarioTwoTest() {
        loginPage = new LoginPage(driver);
        loginPage.LogOn("standard_user", PASSWORD);
        inventoryPage = new InventoryPage(driver);
        inventoryPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.goToCheckout();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillYourInformation("", "", "");
        checkoutPage.continueCheckout();
        checkoutPage.checkError();
        Assert.assertEquals(checkoutPage.checkError().getText(), "Error: First Name is required");
    }

    @Test
    public void firstNameCheckTest() {
        loginPage = new LoginPage(driver);
        loginPage.LogOn("standard_user", PASSWORD);
        inventoryPage = new InventoryPage(driver);
        inventoryPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.goToCheckout();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillYourInformation("", "Watson", "NW1");
        checkoutPage.continueCheckout();
        checkoutPage.checkError();
        Assert.assertEquals(checkoutPage.checkError().getText(), "Error: First Name is required");
    }

    @Test
    public void lastNameCheckTest() {
        loginPage = new LoginPage(driver);
        loginPage.LogOn("standard_user", PASSWORD);
        inventoryPage = new InventoryPage(driver);
        inventoryPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.goToCheckout();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillYourInformation("John", "", "NW1");
        checkoutPage.continueCheckout();
        checkoutPage.checkError();
        Assert.assertEquals(checkoutPage.checkError().getText(), "Error: Last Name is required");
    }

    @Test
    public void zipCodeCheckTest() {
        loginPage = new LoginPage(driver);
        loginPage.LogOn("standard_user", PASSWORD);
        inventoryPage = new InventoryPage(driver);
        inventoryPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.goToCheckout();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillYourInformation("John", "Watson", "");
        checkoutPage.continueCheckout();
        checkoutPage.checkError();
        Assert.assertEquals(checkoutPage.checkError().getText(), "Error: Postal Code is required");
    }
}
