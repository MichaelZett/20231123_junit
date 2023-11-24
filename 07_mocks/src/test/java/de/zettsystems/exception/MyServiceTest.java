package de.zettsystems.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class MyServiceTest {
    @Mock
    private ExternalService externalService;

    private MyService myService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        myService = new MyService(externalService);
    }

    @Test
    void testHandleData_ThrowsException() throws IOException {
        when(externalService.processData(anyString())).thenThrow(new IOException());

        String result = myService.handleData("test");

        assertEquals("Error", result);
    }
}