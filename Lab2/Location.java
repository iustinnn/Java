package org.example;
/**
 * Clasa abstracta Location
 *
 * @author Enea Iustin
 */
public abstract class Location {
    /**
     *Fiecare locatie are un nume, o coordonata x, si una y.
     */

    String name;
    protected int x, y;
/**
 * functii setter si getter pentru toate datele membre
 */
    /**
     * @return name
     */
    public String getName() {   //get
        return name;
    }
    /**
     * @param name numele
     */
    public void setName(String name) { //set
        this.name = name;
    }
    /**
     * @param x coord x
     * @param y coord y
     */
    public void setCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @return y coordonata y
     */
    public int getY() {
        return y;
    }
    /**
     * @param y seteaza coord y
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * @return x
     */
    public int getX() {
        return x;
    }
    /**
     * @param x seteaza coord y
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     *Constructorul principal.
     * @param name numele
     * @param x coordonata x
     * @param y coordonata y
     */
    public Location(String name, int x, int y) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    /**
     * metoda va afisa obiectul sub forma de string
     */
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    /**
     * metoda returneaza true daca doua obiecte Location sunt egale, false daca nu sunt egale
     *    doua obiecte de tip Location sunt egale daca au acelasi nume, sau daca au aceleasi coordonate dar denumiri diferite
     * @param obj
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Location) || obj == null)
            return false;
        Location other = (Location) obj;
        return name.equals(other.name) && !(x == other.x && y == other.y);
    }

}

