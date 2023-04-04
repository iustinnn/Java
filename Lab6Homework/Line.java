package org.example;

import java.awt.*;
import java.io.Serializable;

public class Line implements Serializable {
    public Dot dot1;
    public Dot dot2;
    private boolean isSelected;
    public Color color;

    public Line(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.isSelected = false;
        color=Color.BLACK;
    }

    public Dot getDot1() {
        return dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    // Other methods, such as toString() or equals(), can be added as needed.
}