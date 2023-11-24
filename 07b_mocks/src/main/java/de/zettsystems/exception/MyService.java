package de.zettsystems.exception;

import java.io.IOException;

public class MyService {
    private ExternalService externalService;

    public MyService(ExternalService externalService) {
        this.externalService = externalService;
    }

    public String handleData(String input) {
        try {
            return externalService.processData(input);
        } catch (IOException e) {
            return "Error";
        }
    }
}
