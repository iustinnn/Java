package org.example;

enum RoadType {
    HIGHWAY,
    EXPRESS,
    COUNTRY,

}

public class Road {
    public int speedLimit;
    public int length;
    RoadType type;

    public Road(RoadType type, int speedLimit, int length) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Road{" +
                "speedLimit=" + speedLimit +
                ", length=" + length +
                ", type=" + type +
                '}';
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
}
