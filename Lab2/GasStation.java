package org.example;
/**
 *
 *
 * @author Enea Iustin
 */
public class GasStation extends Location {
    /**
     * Fiecare GasStation are un numar de stations, si gasPrice.
     */
    private int stations;
    private int gasPrice;
    /**
     *Constructorul principal
     * @param name numele
     * @param x coord x
     * @param y coord y
     * @param stations numarul de statii
     * @param gasPrice pretul
     */
    public GasStation(String name, int x, int y, int stations, int gasPrice) {
        super(name, x, y);
        this.stations = stations;
        this.gasPrice = gasPrice;
    }
}
