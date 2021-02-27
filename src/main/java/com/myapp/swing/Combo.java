package com.myapp.swing;

import javax.swing.*;

class Combo extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 500;
    Pump p1;
    Pump p2;
    Pump p3;

    public Combo() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//		setLayout(new BorderLayout(30,0));
        setLayout(null);
        Pressure p = new Pressure();
        p1 = new Pump("P1");
        p2 = new Pump("P2");
        p3 = new Pump("P3");
        Power pow = new Power(p, p1, p2, p3);
        TachometerPanel obpanel = new TachometerPanel(p, pow, p1, p2, p3);
        Auto auto = new Auto(p1, p2, p3, pow);
        PressureIndicator wsk = new PressureIndicator(p);
        ManualControlPanel psr = new ManualControlPanel(obpanel, pow, p1, p2, p3);
        ControlPanel ps = new ControlPanel(obpanel, p, pow, auto, psr.man);
        Scheme scheme = new Scheme();
        add(scheme);
        add(ps);
        add(obpanel);
        add(psr);
        add(wsk);
        scheme.setBounds(180, 40, 350, 112);
        obpanel.setBounds(150, 160, 400, 120);
        ps.setBounds(5, 370, 160, 100);
        psr.setBounds(170, 300, 400, 400);
        wsk.setBounds(4, 15, 50, 220);
//pack();
    }
}
