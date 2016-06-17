package com.epam.atomatedtesting.reallife;

public class Calculator {
    private int memorized;
    private final RemoteCalculationService calculationService;

    public Calculator(RemoteCalculationService calculationService) {
        this.calculationService = calculationService;
        calculationService.registerCalculator(this);
    }

    public void shutDown() {
        calculationService.unregisterCalculator(this);
    }

    public int sum(int a, int b) {
        return calculationService.sum(a, b);
    }

    public double pow(int x, int y) {
        return calculationService.pow(x, y);
    }

    public void memorize(int value) {
        this.memorized = value /*+ 1*/;
    }

    public int getMemorizedValue() {
        return memorized;
    }

    public void resetMemory() {
        memorized = 0;
    }
}
