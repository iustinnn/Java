package org.example;

public class Location {
    String name;
    protected int x, y;
    LocationType tip;

    public LocationType getTip() {
        return tip;
    }

    public void setTip(LocationType tip) {
        this.tip = tip;
    }

    public String getName() {   //get
        return name;
    }

    public void setName(String name) { //set
        this.name = name;
    }

    public void setCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Location(String name, LocationType tip, int x, int y) {
        this.x = x;
        this.y = y;
        this.tip = tip;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", tip=" + tip +
                '}';
    }

}
