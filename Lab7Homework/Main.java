import javax.swing.*;
import java.awt.event.*;

public class Main {

    public static void main(String args[]) {
        Exploration explore = new Exploration(5);
        Robot robot1 = new Robot("Wall-E");
        Robot robot2 = new Robot("R2D2");
        Robot robot3 = new Robot("Optimus Prime");
        Robot robot4 = new Robot("Optimu");

        robot1.setExplore(explore);
        robot2.setExplore(explore);
        robot3.setExplore(explore);
        robot4.setExplore(explore);

        explore.addRobot(robot1);
        explore.addRobot(robot2);
        explore.addRobot(robot3);
        explore.addRobot(robot4);


        JFrame frame = new JFrame("Frame");
        JTextField textField = new JTextField();
        Timekeeper timekeeper = new Timekeeper(10000);
        final int[] indexStart = {0};
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                if (e.getKeyChar() == 'y' || e.getKeyChar() == 'Y') {
                    String input = JOptionPane.showInputDialog(frame, "Enter some text:");
                    if (input != null) {
                        if (input.equals("stop")) {
                            explore.pause();

                        } else if (input.equals("start") && indexStart[0] == 0) {
                            timekeeper.turnOn();
                            timekeeper.start();
                            explore.start();
                            indexStart[0]++;
                            new Thread(() -> {
                                int number=0;
                                while (true) {
                                    if (explore.map.statusFinished) {
                                        // do something when exploration is completed
                                        timekeeper.setExplorationCompleted(true);
                                        if(number==0){
                                            System.out.println("Numarul de valori stocate pentru fiecare:\n"+explore.map.myMap);
                                            number++;
                                        }


                                    }
                                }
                            }).start();

                        } else if (input.equals("start")) {
                            //    timekeeper.start();
                            explore.start();
                        }

                    }
                }

            }
        });
        System.out.println(explore.map.statusFinished);
        frame.getContentPane().add(textField);
        frame.pack();
        frame.setVisible(true);
      //  System.out.println("Numarul de valori stocate pentru fiecare:\n"+explore.map.myMap);

    }

}