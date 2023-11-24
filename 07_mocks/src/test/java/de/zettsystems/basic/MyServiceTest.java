package de.zettsystems.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class MyServiceTest {

    private MyRepository myRepository;

    private MyService testee;

    @BeforeEach
    void setUp() {
        myRepository = mock(MyRepository.class);
        testee = new MyService(myRepository);
    }

    @Test
    void testGetProcessedData() {
        // Konfiguriere das Mock-Objekt, um einen bestimmten Wert zurückzugeben
        when(myRepository.getData()).thenReturn("Mock Data");

        // Rufe die Methode auf, die getestet werden soll
        String result = testee.getProcessedData();

        // Überprüfe das Ergebnis
        assertThat(result).isEqualTo("Processed Mock Data");

        // Stelle sicher, dass die getData-Methode des Mock-Objekts aufgerufen wurde
        verify(myRepository).getData();
    }
}