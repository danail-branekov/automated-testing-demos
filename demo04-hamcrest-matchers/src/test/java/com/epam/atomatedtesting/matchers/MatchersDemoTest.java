package com.epam.atomatedtesting.matchers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MatchersDemoTest {

    @Test
    public void testAllStartWithAAndEndWithB() {
        List<String> list = Arrays.asList("AfooB", "AbarB", "AsomethingElseB");
        for (String listItem : list) {
            assertTrue("String should start with 'A'", listItem.startsWith("A"));
            assertTrue("String should end with 'B'", listItem.endsWith("B"));
        }
    }

    @Test
    public void testAllStartWithAAndEndWithB_WithMatchers() {
        List<String> list = Arrays.asList("AfooB", "AbarB", "AsomethingElseB");
        assertThat("String should start with A and end with B",
                list, everyItem(both(startsWith("A")).and(endsWith("B"))));
    }

}
