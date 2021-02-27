package com.myapp.swing;

import javax.swing.*;
import java.awt.*;

public class PressureIndicator extends JPanel {
    Pressure c;
    int pcurrent;
    int ptasked;

    PressureIndicator(Pressure p) {
        c = p;
        Runnable rws = new RunPointer();
        Thread t = new Thread(rws);
        t.start();
    }

    public void paintComponent(Graphics g1) {
        super.paintComponent(g1); // erase background
        Graphics2D g = (Graphics2D) g1;
        Font f = new Font("SansSerif", Font.BOLD, 16);
        g.setColor(Color.BLACK);
        g.setFont(f);
        g.drawRect(4, 15, 45, 200);
        g.setColor(Color.BLUE);
        g.fillRect(4, 215 - pcurrent, 45, pcurrent);
        g.setColor(new Color(208, 207, 204));

    }

    private class RunPointer implements Runnable {
        RunPointer() {
        }

        ;

        public void run() {
            while (true) {
                pcurrent = c.getpcurrent();
//			
                PressureIndicator.this.repaint();
            }
        }
    }
}