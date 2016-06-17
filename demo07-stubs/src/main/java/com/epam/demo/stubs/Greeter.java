package com.epam.demo.stubs;

public class Greeter {
    private final GreetingProviderService greetingProviderService;

    public Greeter(GreetingProviderService greetingProviderService) {
        this.greetingProviderService = greetingProviderService;
    }

    public String greet(String userName) {
        return String.format("%s, %s!", greetingProviderService.getGreetOfTheDay(), userName);
    }
}
