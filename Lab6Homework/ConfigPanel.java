package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    public void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel=new JLabel("Line probability:");
        Double valoriProbabilitate[] = {0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0};
        linesCombo=new JComboBox(valoriProbabilitate);
        createButton = new JButton("Create new game");
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
        createButton.addActionListener(this::createNewGame);
    }
    private void createNewGame(ActionEvent e){
        frame.dispose();
        MainFrame newFrame = new MainFrame();
        newFrame.setVisible(true);
    }
}
