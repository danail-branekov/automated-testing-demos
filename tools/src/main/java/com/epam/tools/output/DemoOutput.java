package com.epam.tools.output;

public class DemoOutput {
    public static void soutAndDelay(String message) {
        System.out.println("[DemoOutput]: " + message);
        delay(300);
    }

    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
