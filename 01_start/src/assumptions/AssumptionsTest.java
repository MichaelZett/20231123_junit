package assumptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.*;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

class AssumptionsTest {
    Browser testee = new Browser();

    @Test
    void testSpecialEdge() {
        assumeTrue("edge".equals(testee.getType()));
        System.out.printf("Ich teste nur Edge...");
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnlyOnWindows(TestReporter testReporter) {
        testReporter.publishEntry("Ich teste nur auf Windows...");
    }

    @EnabledOnJre(JRE.JAVA_17)
    @Test
    void testOnlyOnJava17(TestReporter testReporter) {
        testReporter.publishEntry("Ich teste nur auf Java 17...");
    }

    @EnabledIf("atNight")
    @Test
    void testOnlyAtNight(TestReporter testReporter) {
        testReporter.publishEntry("Ich teste nur nachts...");
    }

    private boolean atNight() {
        LocalTime localTime = LocalTime.now();
        return localTime.isAfter(LocalTime.of(0, 0, 0)) && localTime.isBefore(LocalTime.of(6, 0, 0));
    }
}
