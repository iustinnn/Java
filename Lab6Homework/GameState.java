package org.example;

import javax.swing.*;
import java.io.Serializable;

public class GameState implements Serializable {
    private JFrame frame;

    public GameState(JFrame frame) {
        this.frame = frame;
    }
}
