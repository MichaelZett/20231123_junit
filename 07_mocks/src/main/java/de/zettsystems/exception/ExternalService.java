package de.zettsystems.exception;

import java.io.IOException;

public class ExternalService {
    public String processData(String input) throws IOException {
        // Stell Dir vor, dass hier eine externe Ressource verarbeitet wird
        return "Processed " + input;
    }
}
