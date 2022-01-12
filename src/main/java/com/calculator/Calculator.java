package com.calculator;

import com.calculator.exception.DivideByZeroException;

public class Calculator {

    public double divide(int a, int b) {
        if (b == 0) {
            throw new DivideByZeroException("division by zero");
        }
        return 1.0 * a / b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
