package com.myapp.swing;

import javax.swing.*;
import java.awt.*;

public class Pump extends JComponent {
    private static final int DEFAULT_WIDTH = 132;
    private static final int DEFAULT_HEIGHT = 52;
    String name = "M";
    boolean state = false;
    boolean f;
    Color col = Color.blue;
    Power pow;
    int powcurrent;
    Runnable runpump;
    Thread t;

    Pump(String s) {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new BorderLayout());
        name = s;
        //pow=p;
    }

    public void setActive() {
        state = !state;
        if (state)
            col = Color.red;
        else
            col = Color.blue;
        repaint();
    }

    public void setInactive() {
        state = false;
        col = Color.blue;
        repaint();
    }

    public void start() {
        //powcurrent=0;
        f = true;
        runpump = new RunPump();
        t = new Thread(runpump);
        t.start();
    }

    public void stop() {
        f = false;
    }

    public void update() {

        //powcurrent=pow.getpowcurrent();
        System.out.println("com.myapp.swing.Pump update powcurrent=" + powcurrent);
        if (powcurrent > 0)//&&name=="P1"&&)
            col = Color.RED;
	/*else if(name=="P2"&&powcurrent>30)
		col=Color.RED;
	else if(name=="P3"&&powcurrent>60)
		col=Color.RED;*/
        else col = Color.BLUE;
        this.repaint();
        try {
            Thread.sleep(190);
        } catch (InterruptedException e) {
        }

    }

    public void network() {
        //if(powcurrent>0)

        if (powcurrent < 30) {
            col = Color.RED;
            this.repaint();
            for (; powcurrent < 30; ) {
                powcurrent++;

                System.out.println("com.myapp.swing.Pump network powcurrent" + powcurrent);
                try {
                    Thread.sleep(180);
                } catch (InterruptedException e) {
                }
            }
            f = false;
        } else
            for (; powcurrent > 0; ) {
                powcurrent--;
                System.out.println("localpow1 " + powcurrent);
                try {
                    Thread.sleep(180);
                } catch (InterruptedException e) {
                }
            }
        if (powcurrent == 0)
            col = Color.BLUE;
        this.repaint();
        f = false;
    }

    public void setpowcurrent(int p) {
        powcurrent = p;
    }

    public int getpowcurrent() {
        return powcurrent;
    }

    public void paintComponent(Graphics g1) {
        super.paintComponent(g1); // erase background
        Graphics2D g = (Graphics2D) g1;
        Font f = new Font("SansSerif", Font.BOLD, 20);
        g.setColor(col);
        g.setFont(f);
        int wspx = 16, wspy = 0;

        g.drawOval(wspx, wspy, 42, 42);
        g.fillOval(wspx, wspy, 42, 42);
        g.setColor(Color.BLACK);
        g.drawString(name, wspx + 13, wspy + 27);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    private class RunPump implements Runnable {


        public void run() {
            while (f)//{
                network();
            //update();}
        }
    }
}