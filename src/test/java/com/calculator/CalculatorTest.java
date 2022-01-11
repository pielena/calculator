package com.calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    @org.junit.Test
    @Parameters({
            "1, 1, 1",
            "-1, -1, 1",
            "-10, 10, -1",
            "99, -100, -0.99"
    })
    public void divide(int first, int second, double expectedDivide) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(expectedDivide, calculator.divide(first, second), 0.01);
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        calculator.divide(3, 0);
    }

    @org.junit.Test
    @Parameters({
            "0, 0, 0",
            "1, 1, 1",
            "-1, -1, 1",
            "-10, 10, -100",
            "99, -100, -9900"
    })
    public void multiply(int first, int second, int expectedMultiply) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(expectedMultiply, calculator.multiply(first, second));
    }

    @org.junit.Test
    @Parameters({
            "0, 0, 0",
            "1, 1, 0",
            "-1, -1, 0",
            "-10, 10, -20",
            "99, -100, 199"
    })
    public void subtract(int first, int second, int expectedSubtract) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(expectedSubtract, calculator.subtract(first, second));
    }

    @org.junit.Test
    @Parameters({
            "0, 0, 0",
            "1, 1, 2",
            "-1, -1, -2",
            "-10, 10, 0",
            "99, -100, -1"
    })
    public void sum(int first, int second, int expectedSum) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(expectedSum, calculator.sum(first, second));
    }
}