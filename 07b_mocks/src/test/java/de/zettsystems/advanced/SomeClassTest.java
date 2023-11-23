package de.zettsystems.advanced;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeClassTest {

    @Test
    void testWithCallback() {
        SomeClass mockObject = mock(SomeClass.class);

        // Konfigurieren des Mocks, um einen Callback zu verwenden
        when(mockObject.someMethod(anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                String input = (String) args[0];
                // Eigene Logik basierend auf den Argumenten
                return "Verarbeitet: " + input;
            }
        });

        // Test der Methode
        String result = mockObject.someMethod("Test");
        assertEquals("Verarbeitet: Test", result);
    }
}