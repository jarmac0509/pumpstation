package com.myapp.swing;

import javax.swing.*;
import java.awt.*;

public class TachometerPanel extends JPanel {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 200;
    public int ptasked;
    Tachometer ob1;
    Tachometer ob2;
    Tachometer ob3;
    com.myapp.swing.Pressure p;
    com.myapp.swing.Power pow;
    com.myapp.swing.Pump pu1;
    com.myapp.swing.Pump pu2;
    com.myapp.swing.Pump pu3;

    TachometerPanel(com.myapp.swing.Pressure c, com.myapp.swing.Power a, com.myapp.swing.Pump p1, com.myapp.swing.Pump p2, com.myapp.swing.Pump p3) {
        p = c;
        pow = a;
        pu1 = p1;
        pu2 = p2;
        pu3 = p3;
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
        ob1 = new Tachometer(p, pow, 1, pu1);
        ob2 = new Tachometer(p, pow, 2, pu2);
        ob3 = new Tachometer(p, pow, 3, pu3);
        add(ob1);
        add(ob2);
        add(ob3);

    }

    int getp() {
        return ptasked * 5;
    }

}
