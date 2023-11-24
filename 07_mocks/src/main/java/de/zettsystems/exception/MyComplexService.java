package de.zettsystems.exception;

public class MyComplexService {
    public String performAction(String input) throws ActionException {
        if ("error".equals(input)) {
            throw new ActionException("Error occurred");
        }
        return "Performed action with " + input;
    }
}