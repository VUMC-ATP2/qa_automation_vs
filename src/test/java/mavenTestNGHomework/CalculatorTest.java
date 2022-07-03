package mavenTestNGHomework;


import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class CalculatorTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("The test has been started");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("All tests done! The end.");
    }

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.sum(5, 5), 10);
        Assert.assertEquals(calculator.sum(6, 5), 11);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.subtract(10, 2), 8);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(10, 5), 2);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(5, 5), 25);
    }

}
