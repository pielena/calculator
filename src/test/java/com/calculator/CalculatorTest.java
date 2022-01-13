package com.calculator;

import com.calculator.exception.DivideByZeroException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void divideTest1() {
        assertEquals(1, calculator.divide(1, 1), 0.01);
    }

    @Test
    public void divideTest2() {
        assertEquals(0.1, calculator.divide(100, 1000), 0.01);
    }

    @Test
    public void divideTest3() {
        assertEquals(126_322_567.47, calculator.divide(2_147_483_647, 17), 0.01);
    }

    @Rule
    public final ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenExceptionThrown_thenRuleIsApplied() {
        exceptionRule.expect(DivideByZeroException.class);
        exceptionRule.expectMessage("division by zero");

        calculator.divide(4, 0);
    }

    @Test
    public void multiplyTest1() {
        assertEquals(0, calculator.multiply(0, 0));
    }

    @Test
    public void multiplyTest2() {
        assertEquals(-1, calculator.multiply(1, -1));
    }

    @Test
    public void multiplyTest3() {
        assertEquals(9999, calculator.multiply(99, 101));
    }

    @Test
    public void multiplyTest4() {
        assertEquals(2_147_473_440, calculator.multiply(12, 178_956_120));
    }

    @Test
    public void subtractTest1() {
        assertEquals(0, calculator.subtract(0, 0));
    }

    @Test
    public void subtractTest2() {
        assertEquals(-2, calculator.subtract(-1, 1));
    }

    @Test
    public void subtractTest3() {
        assertEquals(2, calculator.subtract(101, 99));
    }

    @Test
    public void subtractTest4() {
        assertEquals(2, calculator.subtract(2_147_483_647, 2_147_483_645));
    }

    @Test
    public void sumTest1() {
        assertEquals(0, calculator.sum(0, 0));
    }

    @Test
    public void sumTest2() {
        assertEquals(0, calculator.sum(1, -1));
    }

    @Test
    public void sumTest3() {
        assertEquals(10001, calculator.sum(9999, 2));
    }

    @Test
    public void sumTest4() {
        assertEquals(2_146_031_007, calculator.sum(1_123_432_998, 1_022_598_009));
    }

}