package com.github;

import org.junit.Test;

public class BasicCalculatorTest {
    @Test
    public void test() {
        BasicCalculator calculator = new BasicCalculator();
        int result = calculator.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(result);
    }
}