package com.calculator;

import com.calculator.exception.DivideByZeroException;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Enclosed.class)
public class CalculatorParameterizedTest {

    @RunWith(Parameterized.class)
    public static class DivideTest {

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 1},
                    {-1, -1, 1},
                    {-10, 10, -1},
                    {99, -100, -0.99},
            });
        }

        private final Calculator calculator;
        private final int first;
        private final int second;
        private final double expected;

        public DivideTest(int first, int second, double expected) {
            this.calculator = new Calculator();
            this.first = first;
            this.second = second;
            this.expected = expected;
        }

        @Test
        public void divide() {
            assertEquals(expected, calculator.divide(first, second), 0.01);
        }

        @Test
        public void divideThrowsDivideByZeroException() {
            DivideByZeroException e = assertThrows(DivideByZeroException.class, () -> calculator.divide(4, 0));
            assertEquals("division by zero", e.getMessage());
        }
    }

    @RunWith(Parameterized.class)
    public static class MultiplyTest {

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0, 0, 0},
                    {1, 1, 1},
                    {-1, -1, 1},
                    {-10, 10, -100},
                    {99, -100, -9900}
            });
        }

        private final Calculator calculator;
        private final int first;
        private final int second;
        private final int expected;

        public MultiplyTest(int first, int second, int expected) {
            this.calculator = new Calculator();
            this.first = first;
            this.second = second;
            this.expected = expected;
        }

        @Test
        public void multiply() {
            assertEquals(expected, calculator.multiply(first, second));
        }
    }

    @RunWith(Parameterized.class)
    public static class SubtractTest {

        @Parameter()
        public int first;

        @Parameter(value = 1)
        public int second;

        @Parameter(value = 2)
        public int expected;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0, 0, 0},
                    {1, 1, 0},
                    {-1, -1, 0},
                    {-10, 10, -20},
                    {99, -100, 199}
            });
        }

        @Test
        public void subtract() {
            Calculator calculator = new Calculator();
            assertEquals(expected, calculator.subtract(first, second));
        }
    }

    @RunWith(Parameterized.class)
    public static class SumTest {

        @Parameter()
        public int first;

        @Parameter(value = 1)
        public int second;

        @Parameter(value = 2)
        public int expected;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0, 0, 0},
                    {1, 1, 2},
                    {-1, -1, -2},
                    {-10, 10, 0},
                    {99, -100, -1}
            });
        }

        @Test
        public void sum() {
            Calculator calculator = new Calculator();
            assertEquals(expected, calculator.sum(first, second));
        }
    }
}
