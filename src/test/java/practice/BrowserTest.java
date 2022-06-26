package practice;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class BrowserTest {

    ChromeDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Will initialize ");
        this.driver = new ChromeDriver();
        driver.get("https://google.lv");
    }

    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        // Google//
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }
}
