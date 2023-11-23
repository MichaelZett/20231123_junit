package de.zettsystems.shipment;

import de.zettsystems.common.Time;

import java.time.Duration;
import java.time.Instant;

public class Shipment {
    private Instant startTime;
    private String payload;
    private Instant arrivalTime;

    public Shipment(String payload) {
        this.payload = payload;
    }

    public void sendShipment() {
        this.startTime = Time.currentInstant();
    }

    public void arrive() {
        this.arrivalTime = Time.currentInstant();
    }

    public Duration getDuration() {
        return Duration.between(startTime, arrivalTime);
    }
}
