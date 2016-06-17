package com.epam.atomatedtesting.reallife;

import java.util.ArrayList;
import java.util.List;

public class RemoteCalculationService {
    private final List<Calculator> registeredCalculators = new ArrayList<Calculator>();

    public RemoteCalculationService() {
        System.out.println("Pretend to be doing something slow and useful...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public double pow(int x, int y) {
        return Math.pow(x, y);
    }

    public void registerCalculator(Calculator calculator) {
        registeredCalculators.add(calculator);
    }

    public void unregisterCalculator(Calculator calculator) {
        registeredCalculators.remove(calculator);
    }
}
