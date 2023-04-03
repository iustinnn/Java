package org.example;

import java.awt.*;

public class Line {
    private Dot dot1;
    private Dot dot2;
    private boolean isSelected;
    private Color color;

    public Line(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.isSelected = false;
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