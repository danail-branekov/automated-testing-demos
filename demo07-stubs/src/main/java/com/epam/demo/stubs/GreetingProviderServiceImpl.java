package com.epam.demo.stubs;

public class GreetingProviderServiceImpl implements GreetingProviderService {
    public String getGreetOfTheDay() {
        try {
            connectToRemoteService();
            return "Hello";
        } finally {
            disconnectFromRemoteService();
        }
    }

    private void connectToRemoteService() {
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void disconnectFromRemoteService() {
        try {
            Thread.sleep(999999999);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
