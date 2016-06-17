package com.epam.demo.parameterizedtest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CalculatorTest {
    @Parameter(0)
    public int a;
    @Parameter(1)
    public int b;

    private Calculator calculator;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] values = new Object[][]{{1, 2}, {3, 4}};
        return Arrays.asList(values);
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testPlus() {
        assertThat(calculator.plus(a, b), is(a + b));
    }

    @Test
    public void testMinus() {
        assertThat(calculator.minus(a, b), is(a - b));
    }
}