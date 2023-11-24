package de.zettsystems.answer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MyServiceTest {
    @Mock
    private MyRepository myRepository;

    private MyService myService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        myService = new MyService(myRepository);
    }

    @Test
    void testGetDataByIdSelf() {
        // Konfiguriere das Mock-Objekt, um den ersten übergebenen Parameter zurückzugeben
        when(myRepository.findDataById(anyString())).thenAnswer((Answer<String>) invocation -> {
            Object[] args = invocation.getArguments();
            return (String) args[0];  // gibt den ersten Parameter zurück
        });

        assertEquals("123", myService.getDataById("123"));
        assertEquals("abc", myService.getDataById("abc"));

        verify(myRepository).findDataById("123");
        verify(myRepository).findDataById("abc");
    }

    @Test
    void testGetDataById() {
        // Gibt's schon
        when(myRepository.findDataById(anyString())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        assertEquals("123", myService.getDataById("123"));
        assertEquals("abc", myService.getDataById("abc"));

        verify(myRepository).findDataById("123");
        verify(myRepository).findDataById("abc");
    }
}
