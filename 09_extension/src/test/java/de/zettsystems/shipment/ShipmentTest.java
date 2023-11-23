package de.zettsystems.shipment;

import de.zettsystems.common.Time;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;


class ShipmentTest {

    @BeforeEach
    void setUp() {
        Time.useSystemDefaultZoneClock();
    }

    @AfterEach
    void tearDown() {
        Time.useSystemDefaultZoneClock();
    }

    @Test
    void sendShipmentNow() throws InterruptedException {
        Shipment testee = new Shipment("Playstation");

        testee.sendShipment();

        Thread.sleep(2000L);

        testee.arrive();

        Duration duration = testee.getDuration();
        System.out.println(duration);
        assertThat(duration).isCloseTo(Duration.ofMillis(2000L), Duration.ofMillis(25L));
    }

    @Test
    void sendShipmentWithTime() throws InterruptedException {
        Shipment testee = new Shipment("Playstation");

        Time.useMockTime(LocalDateTime.of(2021, 10, 31, 12, 15), ZoneId.of("Europe/Berlin"));
        testee.sendShipment();

        Time.useMockTime(LocalDateTime.of(2021, 11, 26, 12, 15), ZoneId.of("Europe/Berlin"));

        testee.arrive();

        assertThat(testee.getDuration()).isEqualTo(Duration.ofDays(26L));
    }
}