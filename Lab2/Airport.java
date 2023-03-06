package org.example;

public class Airport extends Location {
    /**
     * Fiecare Airport are un numar de terminals,flights si runways.
     */
    private int terminals;
    private int flights;
    private int runways;

    /**
     *Constructorul principal
     * @param name numele
     * @param x coord x
     * @param y coord y
     * @param terminals terminale
     * @param runways linii
     * @param flights zboruri
     */
    public Airport(String name, int x, int y, int terminals, int runways, int flights) {
        super(name, x, y);
        this.terminals = terminals;
        this.runways = runways;
        this.flights = flights;
    }

}
