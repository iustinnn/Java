package org.example;

public class Highway extends Road {
    private int highwayNumber;
    private int highwayStops;

    public Highway(String name, int speedLimit, int length, int highwayNumber, int highwayStops) {
        super(name, speedLimit, length);
        this.highwayNumber = highwayNumber;
        this.highwayStops = highwayStops;

    }
}
