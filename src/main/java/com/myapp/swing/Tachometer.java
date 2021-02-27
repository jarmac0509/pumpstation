package com.myapp.swing;

import javax.swing.*;
import java.awt.*;

public class Tachometer extends JPanel {
    private static final int DEFAULT_WIDTH = 100;
    private static final int DEFAULT_HEIGHT = 100;
    JButton but;
    int pcurrent;
    int ptasked;
    com.myapp.swing.Pressure pa;
    com.myapp.swing.Power pow;
    com.myapp.swing.Pump pu;
    int id, lp1, n = 0;
    boolean fin, fin2, f1, f2, f3;
    Runnable rob, rman;
    Thread w1, w2;

    Tachometer(com.myapp.swing.Pressure c, com.myapp.swing.Power a, int i, com.myapp.swing.Pump p) {
        id = i;
        pa = c;
        pow = a;
        pu = p;
        rob = new AutoTachometer(this);
        rman = new ManTachometer(this);
        w1 = new Thread(rob);
    }

    public void auto() {
        fin = false;
        w1 = new Thread(rob);
        w1.start();
    }

    public void stop() {
        pcurrent = 0;
        ptasked = 0;
        lp1 = 0;
        fin = true;
        repaint();
    }

    ;

    public void manual() {
        fin = true;
        fin2 = false;
        f3 = true;
        w2 = new Thread(rman);
        w2.start();
    }

    public void paintComponent(Graphics g1) {
        super.paintComponent(g1); // erase background
        Graphics2D g = (Graphics2D) g1;
        Font f = new Font("SansSerif", Font.BOLD, 16);
        g.setColor(Color.BLUE);
        g.setFont(f);
        int wspx = 0, wspy = 0;
        g.setColor(new Color(208, 207, 232));
        g.fillRect(wspx + 1, wspy + 1, 200, 200);
        g.setColor(new Color(208, 207, 204));
        g.setColor(Color.GREEN);
        g.drawArc(wspx, wspy, 100, 100, 0, 180);
        g.setColor(Color.red);
        g.fillArc(wspx, wspy, 100, 100, 0, 60);
        g.setColor(Color.GREEN);
        g.fillArc(wspx, wspy, 100, 100, 60, 120);
        g.setColor(Color.yellow);
        g.fillArc(wspx, wspy, 100, 100, 120, 180);
        g.drawArc(wspx + 10, wspy + 10, 80, 80, 0, 180);
        g.setColor(Color.white);
        g.fillArc(wspx + 10, wspy + 10, 80, 80, 0, 180);
        g.setColor(new Color(208, 207, 232));
        g.fillArc(wspx, wspy, 100, 100, 0, -180);
        g.setColor(Color.black);
        //g.drawString("60", wspx + 89, wspy + 27);

        double angle;
        int x1, y1, x2, y2;
        for (int i = 6; i <= 12; i++) {
            angle = 2 * Math.PI * (i / 12.0);
            x1 = (int) (50 * Math.cos(angle)) + 50 + wspx;
            y1 = (int) (50 * Math.sin(angle)) + 50 + wspy;
            x2 = (int) (45 * Math.cos(angle)) + 50 + wspx;
            y2 = (int) (45 * Math.sin(angle)) + 50 + wspy;
            g.drawLine(x1, y1, x2, y2);
        }
        for (int i = 30; i <= 60; i++) {
            angle = 2 * Math.PI * (i / 60.0);
            x1 = (int) (50 * Math.cos(angle)) + 50 + wspx;
            y1 = (int) (50 * Math.sin(angle)) + 50 + wspy;
            x2 = (int) (48 * Math.cos(angle)) + 50 + wspx;
            y2 = (int) (48 * Math.sin(angle)) + 50 + wspy;
            g.drawLine(x1, y1, x2, y2);
        }

        angle = 2 * Math.PI * ((pcurrent - 15) / 60.0) - (Math.PI / 2);
        x1 = (int) (40 * Math.cos(angle));
        y1 = (int) (40 * Math.sin(angle));
        g.drawLine(50 + wspx, 50 + wspy, 50 + x1 + wspx, 50 + y1 + wspy);

    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void update() {//if(fin!=true){
        lp1 = pow.getpowcurrent();//}
        if (id == 1 && lp1 <= 30) {
            if (pcurrent < lp1)
                for (; lp1 > pcurrent; ) {
                    pcurrent++;
                    System.out.println("com.myapp.swing.Tachometer a update t1 local powcurrent " + pcurrent);
                    this.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                }

            else if (lp1 < pcurrent)
                for (; lp1 < pcurrent; ) {
                    pcurrent--;
                    this.repaint();
                    System.out.println("com.myapp.swing.Tachometer a update t1 local powcurrent " + pcurrent);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                }
        } else if (id == 2 && lp1 >= 30 && lp1 <= 60) {

            if (lp1 - 30 > pcurrent)

                for (; pcurrent < lp1 - 30; ) {
                    pcurrent++;
                    this.repaint();
                    System.out.println("com.myapp.swing.Tachometer a update t2 local powcurrent " + pcurrent);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                }
            else if (lp1 - 30 <= pcurrent)
                for (; pcurrent > lp1 - 30; ) {
                    --pcurrent;
                    this.repaint();
                    System.out.println("com.myapp.swing.Tachometer a update t2 local powcurrent " + pcurrent);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
        } else if (id == 3 && lp1 >= 60) {
            if (lp1 - 60 > pcurrent)
                for (; pcurrent < lp1 - 60; ) {
                    ++pcurrent;
                    this.repaint();
                    System.out.println("com.myapp.swing.Tachometer a update  t3 local powcurrent " + pcurrent);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }

            else if (lp1 - 60 < pcurrent)
                for (; pcurrent > lp1 - 60; ) {
                    pcurrent--;
                    this.repaint();
                    System.out.println("com.myapp.swing.Tachometer a update  t3 local powcurrent " + pcurrent);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
        }
    }

    public void network() {
        f1 = !f1;
        //f2=true;
    }

    public void manupdateon(boolean b) {
        //if(lp1>0){

        if (b && f3) {
            pu.col = Color.RED;
            pu.repaint();
            for (; 30 > pcurrent; ) {
                pcurrent++;
                this.repaint();
                System.out.println("com.myapp.swing.Tachometer network t local powcurrent " + pcurrent);

                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public void manupdateoff(boolean b) {
        if (!b && f3)
            for (; 0 < pcurrent; ) {
                pcurrent--;
                this.repaint();
                System.out.println("com.myapp.swing.Tachometer network t local powcurrent " + pcurrent);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                }

            }
        if (pcurrent == 0)
            pu.col = Color.BLUE;
        pu.repaint();
    }

    public void setconverter() {
        f3 = false;
    }

    public void up() {
        pu.col = Color.RED;
        pu.repaint();
        if (pcurrent < 30)
            pcurrent++;
        this.repaint();
    }

    public void down() {
        if (pcurrent > 0)
            pcurrent--;
        if (pcurrent == 0)
            pu.col = Color.BLUE;
        pu.repaint();
        this.repaint();
    }

    private class AutoTachometer implements Runnable {
        Tachometer obr;

        AutoTachometer(Tachometer o) {
            obr = o;
        }

        public void run() {
            while (fin != true) {
                // System.out.println("teraz aktualizuje");
                obr.update();
                //obr.manupdateon();
                // System.out.println("teraz repainuje");
                // obr.repaint();
            }
        }
    }

    private class ManTachometer implements Runnable {
        Tachometer obr;

        ManTachometer(Tachometer o) {
            obr = o;
        }

        public void run() {
            while (fin2 != true) {
                // System.out.println("teraz aktualizuje");
                //obr.update();
                obr.manupdateon(f1);
                obr.manupdateoff(f1);
                // System.out.println("teraz repainuje");
                // obr.repaint();
            }
        }
    }
}