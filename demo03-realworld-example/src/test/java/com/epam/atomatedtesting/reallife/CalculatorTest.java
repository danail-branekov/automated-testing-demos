package com.epam.atomatedtesting.reallife;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static RemoteCalculationService calculationService;
    private Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        calculationService = new RemoteCalculationService();
    }

    @Before
    public void setUp() {
        calculator = new Calculator(calculationService);
    }

    @After
    public void tearDown() {
        calculator.shutDown();
    }

    @Test
    public void testSum() {
        assertEquals("1+2 should be 3", 3, calculator.sum(1, 2));
    }

    @Test
    public void testPow() {
        assertEquals("2 pow 3 should be 8", 8, calculator.pow(2, 3), 0);
    }

    @Test
    public void testMemorize() {
        calculator.memorize(1234);
        assertEquals("Unexpected memory", 1234, calculator.getMemorizedValue());
    }
}