package com.epam.atomatedtesting.verifyingexceptions;

public class ExceptionThrowingTool {
    public boolean doSomethingUseful(String a, String b) throws UnusefulException {
        if (a.equals(b)) {
            return true;
        }

        throw new UnusefulException(String.format("I cannot handle parameters '%s' and '%s'", a, b));
    }
}
