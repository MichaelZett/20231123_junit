package de.zettsystems.exception;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MyComplexServiceTest {

    @Mock
    private MyComplexService myComplexService;

    @Disabled
    @Test
    void testPerformAction_Error_withWhen() throws ActionException {
        MyComplexService resource = mock(MyComplexService.class);

        // Diese Zeile führt zu einem Problem
        when(resource.performAction("error")).thenReturn("No Error");

        assertThrows(ActionException.class, () -> resource.performAction("error"));
    }

    @Test
    void testPerformAction_Error_withDoReturn() throws ActionException {
        MyComplexService resource = mock(MyComplexService.class);

        // Verwendung von doReturn().when() vermeidet das Problem
        doReturn("No Error").when(resource).performAction("error");

        assertEquals("No Error", resource.performAction("error"));
    }
}
