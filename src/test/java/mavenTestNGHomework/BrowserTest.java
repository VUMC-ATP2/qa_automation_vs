package mavenTestNGHomework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class BrowserTest {
    ChromeDriver chromeDriver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        this.chromeDriver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        chromeDriver.get("https://www.delfi.lv/");
        Assert.assertEquals(chromeDriver.getTitle(), "DELFI - Vadošais ziņu portāls Latvijā - DELFI");
    }

    @Test
    public void secondTest() {
        chromeDriver.get("https://marine.meteo.lv/");
        Assert.assertEquals(chromeDriver.getTitle(), "Jūras datu portals");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        chromeDriver.close();
        chromeDriver.quit();
    }

}
