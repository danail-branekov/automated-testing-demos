package com.epam.atomatedtesting.junit4.assertions;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionsDemoTest {
    @Test
    public void assertEqualsDemo() {
        assertEquals("A and A should be equal", "A", "A");
        assertEquals("A and A should be equal again", new String("A"), new String("A"));
        assertNotSame("A and A are equal but not the same", new String("A"), new String("A"));

        assertNotEquals("A and B should not be equal", "A", "B");
    }

    @Test
    public void assertEqualsWithToleranceDemo() {
        double value_1 = 0.123;
        double value_2 = 0.124;
        assertEquals("Values should be equal when tolerant", value_1, value_2, 0.01);
        assertNotEquals("Values should not be equal when not tolerant enough", value_1, value_2, 0.000001);
    }

    @Test
    public void assertBooleanDemo() {
        assertTrue("True should be true", true);
        assertFalse("False should not be true", false);
    }

    @Test
    public void assertNullDemo() {
        assertNull("null should be null", null);
        assertNotNull("A new object should be never null", new Object());
    }

    @Test
    public void assertSameTest() {
        String myString = "my-string";
        String anotherString = myString;
        assertSame("Strings should be same instance", myString, anotherString);
        assertNotSame("My string should not be the same as an equal new string", myString, new String("my-string"));
    }

    @Ignore("make Maven happy")
    @Test
    public void assertFailureDemo() {
        assertEquals("I was expecting something else", "expected", "not-really-expected");
    }

    @Ignore("make Maven happy")
    @Test
    public void failDemo() {
        fail("You shall not pass!");
    }
}
