package org.example;

import java.awt.*;
import java.io.Serializable;

public class Dot implements Serializable {
    private int x;
    private int y;
    public static int index = 1;
    private Color color;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.BLACK; // By default, dots are black.
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // Other methods, such as toString() or equals(), can be added as needed.
}
