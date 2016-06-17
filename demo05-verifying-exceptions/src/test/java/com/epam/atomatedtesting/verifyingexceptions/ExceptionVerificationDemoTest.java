package com.epam.atomatedtesting.verifyingexceptions;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

public class ExceptionVerificationDemoTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ExceptionThrowingTool tool;

    @Before
    public void setUp() {
        tool = new ExceptionThrowingTool();
    }

    @Test
    public void verifyExceptionNotRecommended() {
        try {
            tool.doSomethingUseful("A", "B");
            fail("UnusefulException not thrown");
        } catch (UnusefulException e) {
            // expected
        }
    }

    @Test(expected = UnusefulException.class)
    public void verifyExceptionWithExpected() throws UnusefulException {
        tool.doSomethingUseful("A", "B");
    }

    @Test
    public void verifyExceptionWithRule() throws UnusefulException {
        expectedException.expect(UnusefulException.class);
        tool.doSomethingUseful("A", "B");
    }

    @Test
    public void verifyExceptionWithRuleAndMatcher() throws UnusefulException {
        expectedException.expect(UnusefulException.class);
        expectedException.expectMessage(Matchers.containsString("cannot handle parameters"));
        tool.doSomethingUseful("A", "B");
    }

    @Test
    public void verifyExceptionWithRuleAndCustomMatcher() throws UnusefulException {
        expectedException.expect(new BaseMatcher<Exception>() {
            public void describeTo(Description description) {
                description.appendText("UnusefulException with message containing 'cannot handle parameters'");
            }

            public boolean matches(Object o) {
                if (!(o instanceof UnusefulException)) {
                    return false;
                }

                UnusefulException unusefulException = (UnusefulException) o;
                return unusefulException.getMessage().contains("cannot handle parameters");
            }
        });
        expectedException.expectMessage(Matchers.containsString("cannot handle parameters"));

        tool.doSomethingUseful("A", "B");
    }
}
