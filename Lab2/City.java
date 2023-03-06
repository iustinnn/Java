package org.example;

public class City extends Location {
    /**
     * Fiecare City are o population.
     */
    private int population;
    /**
     *Constructorul principal
     * @param name numele
     * @param x coord x
     * @param y coord y
     * @param population populatia orasului
     */
    public City(String name, int x, int y, int population) {
        super(name, x, y);
        this.population = population;
    }

}
