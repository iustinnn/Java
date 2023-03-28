package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        frame.configPanel.dotsSpinner.addChangeListener(new ChangeListener() { //avem un listener care asculta butonul cu nr de noduri
            public void stateChanged(ChangeEvent e) {
                numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
                createOffscreenImage();
                initPanel();
                createBoard();
                createVertices();
                drawLines();
                repaint();
            }
        });
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        frame.configPanel.linesCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
                createOffscreenImage();
                initPanel();
                createBoard();
                createVertices();
                drawLines();
                repaint();
            }
        });
        createOffscreenImage();
        createVertices();
        drawLines();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
        //crearea lor grafica
        graphics.setColor(Color.BLACK);
        int circleRadius = 10;
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - circleRadius / 2, y[i] - circleRadius / 2, circleRadius, circleRadius);
        }
    }

    private void drawLines() {
        Random rand = new Random();
        System.out.println(numVertices);
        for (int i = 0; i < numVertices - 1; i++)
            for (int j = i + 1; j < numVertices ; j++) {
                double randNumber = rand.nextDouble(1);
                if (randNumber < edgeProbability) {
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
    }

    @Override
    public void update(Graphics g) {
    } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}