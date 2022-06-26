import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        calculator.sum(10.00, 25.00);
        Assert.assertEquals(calculator.sum(10.00, 25.00), 35.00);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        calculator.subtract(30, 20);
        Assert.assertEquals(calculator.subtract(30, 20), 10);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        calculator.divide(20, 2);
        Assert.assertEquals(calculator.divide(20, 2), 10);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        calculator.multiply(2, 10);
        Assert.assertEquals(calculator.multiply(2, 10), 20);

    }
}

