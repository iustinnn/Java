package org.example;
/**
 * Clasa abstracta Road
 *
 * @author Enea Iustin
 */
public abstract class Road {
    /**
     * Fiecare Road are speedLimit, length si un name.
     */
    public int speedLimit;
    public int length;
    public String name;
    /**
     *Constructorul principal
     * @param name numele
     * @param speedLimit limita de viteza
     * @param length lungimea drumului
     */
    public Road(String name, int speedLimit, int length) {
        this.name=name;
        this.speedLimit = speedLimit;
        this.length = length;
    }
    /**
     * metoda va afisa obiectul sub forma de string
     */
    @Override
    public String toString() {
        return "Road{" +
                "speedLimit=" + speedLimit +
                ", length=" + length +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Road)||obj==null)
            return false;
        Road other=(Road) obj;
        return name.equals(other.name);
    }
    /**
     * functii setter si getter pentru toate datele membre
     */
    /**
     * @return speedLimit
     */
    public int getSpeedLimit() {
        return speedLimit;
    }
    /**
     * @return length
     */
    public int getLength() {
        return length;
    }
    /**
     * @param length lungimea
     */
    public void setLength(int length) {
        this.length = length;
    }
    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

}

