package com.calculator;

import com.calculator.exception.DivideByZeroException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void divideTest1() throws DivideByZeroException {
        Assert.assertEquals(1, calculator.divide(1, 1), 0.01);
    }

    @Test
    public void divideTest2() throws DivideByZeroException {
        Assert.assertEquals(0.1, calculator.divide(100, 1000), 0.01);
    }

    @org.junit.Test(expected = DivideByZeroException.class)
    public void testDivideByZero() throws DivideByZeroException {
        Calculator calculator = new Calculator();
        calculator.divide(3, 0);
    }

    @Test
    public void multiplyTest1() {
        Assert.assertEquals(0, calculator.multiply(0, 0));
    }

    @Test
    public void multiplyTest2() {
        Assert.assertEquals(-1, calculator.multiply(1, -1));
    }

    @Test
    public void multiplyTest3() {
        Assert.assertEquals(9999, calculator.multiply(99, 101));
    }

    @Test
    public void subtractTest1() {
        Assert.assertEquals(0, calculator.subtract(0, 0));
    }

    @Test
    public void subtractTest2() {
        Assert.assertEquals(-2, calculator.subtract(-1, 1));
    }

    @Test
    public void subtractTest3() {
        Assert.assertEquals(2, calculator.subtract(101, 99));
    }

    @Test
    public void sumTest1() {
        Assert.assertEquals(0, calculator.sum(0, 0));
    }

    @Test
    public void sumTest2() {
        Assert.assertEquals(0, calculator.sum(1, -1));
    }

    @Test
    public void sumTest3() {
        Assert.assertEquals(10001, calculator.sum(9999, 2));
    }

}