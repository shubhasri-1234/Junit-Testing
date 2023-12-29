package org.example;

// Ride.java
public class Ride {
    private double distance;
    private double time;
    private String type;

    public Ride(double distance, int time, String type) {
        this.distance = distance;
        this.time = time;
        this.type = type;
    }

    // Getter methods for distance, time, and type
    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public String getType() {
        return type;
    }
}
