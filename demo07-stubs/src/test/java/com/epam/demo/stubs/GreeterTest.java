package com.epam.demo.stubs;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GreeterTest {
    @Test
    public void testGreetWorld() {
        Greeter greeter = new Greeter(new GreetingProviderServiceStub("Hi"));
        assertThat(greeter.greet("world"), is("Hi, world!"));
    }

    private class GreetingProviderServiceStub implements GreetingProviderService {
        private final String greet;

        private GreetingProviderServiceStub(String greet) {
            this.greet = greet;
        }

        public String getGreetOfTheDay() {
            return greet;
        }
    }
}