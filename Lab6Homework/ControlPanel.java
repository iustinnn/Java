    package org.example;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.io.*;

    public class ControlPanel extends JPanel {
        final MainFrame frame;
        public int indexLoad=0;
        Graphics2D graphics;
        JButton exitBtn = new JButton("Exit");
        JButton saveBtn = new JButton("Save");
        JButton loadBtn = new JButton("Load");

        //create all buttons (Load, Exit, etc.)
        public ControlPanel(MainFrame frame) {
            this.frame = frame;
            init();
        }

        private void init() {
            //change the default layout manager (just for fun)
            setLayout(new FlowLayout());
            add(exitBtn);
            add(saveBtn);
            add(loadBtn);
            //configure listeners for all buttons
            exitBtn.addActionListener(this::exitGame);
            saveBtn.addActionListener(this::saveGame);
            loadBtn.addActionListener(this::loadGame);
        }

        private void exitGame(ActionEvent e) {
            frame.dispose();
        }

        private void saveGame(ActionEvent e) {
            Line[][] linesSaved = frame.canvas.lines;
            int turnSaved = frame.canvas.userTurn;
            Dot[] dotsSaved = frame.canvas.dots;
            int verticesSaved = frame.canvas.numVertices;
    double edgeProbabilitySaved=frame.canvas.edgeProbability;
            System.out.println(frame.toString());
            try {
                FileOutputStream fileOut = new FileOutputStream("gameState.ser");
                System.out.println("1");
                ObjectOutputStream output = new ObjectOutputStream(fileOut);
                System.out.println("2");
                for (int i = 0; i < verticesSaved - 1; i++)
                    for (int j = i + 1; j < verticesSaved; j++) {
                        if(linesSaved[i][j]!=null){
                            System.out.println(linesSaved[i][j].color);
                        }
                    }
                output.writeObject(linesSaved);
                output.writeInt(turnSaved);
                output.writeObject(dotsSaved);
                output.writeInt(verticesSaved);
                output.writeDouble(edgeProbabilitySaved);
                System.out.println("3");
                output.close();
                fileOut.close();

            } catch (Exception er) {
                er.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to save game state");
            }
            JOptionPane.showMessageDialog(this, "Game state has been saved to gameState.ser");
        }

        private void loadGame(ActionEvent e){
            indexLoad=1;
            try{
                FileInputStream fis = new FileInputStream("gameState.ser");
                ObjectInputStream in = new ObjectInputStream(fis);
                Line[][] linesLoaded = (Line[][]) in.readObject();
                int turnLoaded = (int)in.readInt();
                Dot[] dotsLoaded = (Dot[]) in.readObject();
                int verticesLoaded = (int) in.readInt();
                double edgeProbabilityLoaded=(double)in.readDouble();
                for (int i = 0; i < verticesLoaded - 1; i++)
                    for (int j = i + 1; j < verticesLoaded; j++) {
                        if(linesLoaded[i][j]!=null){
                            System.out.println(linesLoaded[i][j].color);
                        }
                    }
                System.out.println("next:");
                System.out.println(linesLoaded);
                System.out.println(turnLoaded);
                System.out.println(dotsLoaded);
                System.out.println(verticesLoaded);
                int oldVertices= frame.canvas.numVertices;
                Line[][] oldLines=frame.canvas.lines;
                frame.canvas.lines=linesLoaded;
                frame.canvas.userTurn=turnLoaded;
                frame.canvas.dots=dotsLoaded;
                frame.canvas.numVertices=verticesLoaded;
              // frame.configPanel.dotsSpinner.setValue(verticesLoaded);
            // frame.configPanel.linesCombo.setSelectedItem(edgeProbabilityLoaded);
             frame.canvas.recolorGame(linesLoaded,dotsLoaded,turnLoaded,verticesLoaded,edgeProbabilityLoaded,oldVertices,oldLines);
             frame.setVisible(true);
            }catch (IOException err){
                System.out.println("ERROR");
            }
            catch (ClassNotFoundException errr){
                System.out.println("Clasa nu exista");
            }


        }
    }
