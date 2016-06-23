package com.epam.atomatedtesting.junit4.annotations;

import org.junit.*;

import static com.epam.atomatedtesting.junit4.annotations.DemoOutput.soutAndDelay;

public class AnnotationsDemoTest {
    @BeforeClass
    public static void beforeClass() {
        soutAndDelay("@BeforeClass");
    }

    @Before
    public void before() {
        soutAndDelay("@Before");
    }

    @Test
    public void test() {
        soutAndDelay("@Test");
    }

    @Test
    @Ignore
    //@Ignore("Temporarily ignored")
    public void ignoredTest() {
        soutAndDelay("This test is ignored!");
    }

    @After
    public void after() {
        soutAndDelay("@After");
    }

    @AfterClass
    public static void afterClass() {
        soutAndDelay("@AfterClass");
    }
}
