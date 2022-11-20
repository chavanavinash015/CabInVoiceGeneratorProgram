package com.bridgelabz;

public class Ride {
    private final double distance;
    private final double time;

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }
}
