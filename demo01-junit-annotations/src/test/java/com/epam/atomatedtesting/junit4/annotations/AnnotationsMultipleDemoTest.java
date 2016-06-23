package com.epam.atomatedtesting.junit4.annotations;

import org.junit.*;

import static com.epam.atomatedtesting.junit4.annotations.DemoOutput.soutAndDelay;

public class AnnotationsMultipleDemoTest {
    @BeforeClass
    public static void beforeClass_First() {
        soutAndDelay("@BeforeClass - First");
    }

    @BeforeClass
    public static void beforeClass_Second() {
        soutAndDelay("@BeforeClass - Second");
    }

    @Before
    public void before_First() {
        soutAndDelay("@Before - First");
    }

    @Before
    public void before_Second() {
        soutAndDelay("@Before - Second");
    }

    @Test
    public void test_First() {
        soutAndDelay("@Test - First");
    }

    @Test
    public void test_Second() {
        soutAndDelay("@Test - Second");
    }

    @After
    public void after_First() {
        soutAndDelay("@After - First");
    }

    @After
    public void after_Second() {
        soutAndDelay("@After - Second");
    }

    @AfterClass
    public static void afterClass_First() {
        soutAndDelay("@AfterClass - First");
    }

    @AfterClass
    public static void afterClass_Second() {
        soutAndDelay("@AfterClass - Second");
    }
}
