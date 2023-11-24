package de.zettsystems.answer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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
        when(myRepository.save(any(Entity.class), eq("id"))).thenAnswer((Answer<Entity>) invocation -> {
            Object[] args = invocation.getArguments();
            return (Entity) args[0];  // gibt den ersten Parameter zurück
        });

        assertEquals("123", myService.getDataById("123", LocalDate.now()).name());
        assertEquals("abc", myService.getDataById("abc", LocalDate.now()).name());
    }

    @Test
    void testGetDataById() {
        // Gibt's schon
        when(myRepository.save(any(Entity.class), anyString())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        assertEquals("123", myService.getDataById("123", LocalDate.now()).name());
        LocalDate now = LocalDate.now();
        assertEquals(now, myService.getDataById("abc", now).birthday());
    }

//    Invalid use of argument matchers!
//            2 matchers expected, 1 recorded: --> Entweder alles Matcher, oder keiner
}
