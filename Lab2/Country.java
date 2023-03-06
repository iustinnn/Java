package org.example;

public class Country extends Road {
    private int stops;
    private int toilets;

    public Country(String name, int speedLimit, int length, int stops, int toilets) {
        super(name, speedLimit, length);
        this.stops = stops;
        this.toilets = toilets;

    }
}
