package org.example;

public class Express extends Road {
    private int parkingSpots;

    public Express(String name, int speedLimit, int length, int parkingSpots) {
        super(name, speedLimit, length);
        this.parkingSpots = parkingSpots;

    }
}
