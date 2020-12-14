package com.github.IskanderO.LabsParallel.lab1;

import java.io.Serializable;

public class Flights implements Serializable {
    private Double delay = 0.0;
    private Boolean cancelled = false;


    public Flights(String delay, String cancelled) {
        if (!delay.isEmpty())
            this.delay = Double.parseDouble(delay);

        if (cancelled.equals("1.00"))
            this.cancelled = true;
    }

    public Double getDelay() {
        return delay;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public Flights update(Flights newFlights) {
        Double newDelay = newFlights.getDelay();
    }
}
