package com.myapp.swing;

public class Power {
    int powcurrent;
    int powtasked;
    boolean f;
    com.myapp.swing.Pressure p;
    com.myapp.swing.Pump pu1;
    com.myapp.swing.Pump pu2;
    com.myapp.swing.Pump pu3;
    Runnable rws;
    Thread t;

    Power(com.myapp.swing.Pressure x, com.myapp.swing.Pump p1, com.myapp.swing.Pump p2, com.myapp.swing.Pump p3) {
        rws = new RunPointer();
        p = x;
        pu1 = p1;
        pu2 = p2;
        pu3 = p3;

    }

    public void reset() {
        f = false;
        powcurrent = 0;
        powtasked = 0;
    }

    public void start() {
        f = true;
        Thread t = new Thread(rws);
        t.start();
    }

    public void setpower() {

        powcurrent = pu1.getpowcurrent() + pu2.getpowcurrent() + pu3.getpowcurrent();
        System.out.println("pu1 " + pu1.getpowcurrent());
        System.out.println("pu2 " + pu2.getpowcurrent());
        System.out.println("pu3 " + pu3.getpowcurrent());
        System.out.println("com.myapp.swing.Power setpower powcurrent " + powcurrent);
        try {
            Thread.sleep(70);
        } catch (InterruptedException e) {
        }
    }

    public void update() {
        if (powtasked > powcurrent)
            for (; powcurrent < powtasked; ) {
                powcurrent++;
                p.setpcurrent(powcurrent);
                //pu1.setpowcurrent(powcurrent);
                System.out.println("com.myapp.swing.Power update powcurrent " + powcurrent);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                }
            }
        else if (powtasked < powcurrent)
            for (; powcurrent > powtasked; ) {
                powcurrent--;
                p.setpcurrent(powcurrent);
                System.out.println("com.myapp.swing.Power update powcurrent " + powcurrent);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                }
            }
    }

    public int getpowcurrent() {
        return powcurrent;
    }

    public void settasked(int a) {
        powtasked = a;
    }

    private class RunPointer implements Runnable {
        RunPointer() {
        }

        public void run() {
            while (f) {
                update();
//		WskaznikCisnienia.this.repaint();
            }
        }
    }
}
