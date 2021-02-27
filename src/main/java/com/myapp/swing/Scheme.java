package com.myapp.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class Scheme extends JPanel {


    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 200;
    int[] wsp = new int[100];

    Scheme() {

    }

    public void paintComponent(Graphics g1) {
        super.paintComponent(g1); // erase background
        Graphics2D g = (Graphics2D) g1;
        Font f = new Font("SansSerif", Font.BOLD, 14);
        g.setColor(Color.blue);
        g.setFont(f);
        int wspx = 0, wspy = 0;

        g.drawRect(wspx + 10, wspy + 10, 80, 90);
        g.fillRect(wspx + 10, wspy + 10, 80, 90);
        g.setColor(Color.BLACK);
        g.drawString("Container", wspx + 12, wspy + 60);
        int[] xp8 = {90, 110, 110, 150, 150, 120, 120, 150, 150, 120, 120,
                150, 150, 110, 110, 90,};
        int[] yp8 = {50, 50, 10, 10, 20, 20, 50, 50, 60, 60, 90, 90, 100, 100, 60, 60};
        int l = xp8.length;
        GeneralPath gp1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, l);
        gp1.moveTo(xp8[0], yp8[0]);
        for (int k = 1; k < l; k++)
            gp1.lineTo(xp8[k], yp8[k]);
        g.setColor(Color.BLUE);
        g.draw(gp1);

        g.drawOval(150, 0, 30, 30);
        g.drawOval(150, 40, 30, 30);
        g.drawOval(150, 80, 30, 30);
        g.drawString("P1", 158, 20);
        g.drawString("P2", 158, 60);
        g.drawString("P3", 158, 100);
        int[] xp9 = {180, 250, 250, 270, 270, 250, 250, 180, 180, 240, 240, 180, 180,
                240, 240, 180, 180};
        int[] yp9 = {10, 10, 50, 50, 60, 60, 100, 100, 90, 90, 60, 60, 50, 50, 20, 20, 10};
        l = xp9.length;
        GeneralPath gp2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, l);
        gp2.moveTo(xp9[0], yp9[0]);
        for (int k = 1; k < l; k++)
            gp2.lineTo(xp9[k], yp9[k]);
        g.setColor(Color.BLUE);
        g.draw(gp2);
        //zawory
        int[] xp = {205, 225, 205, 225};
        int[] yp = {45, 45, 65, 65};
        int[] xp2 = {205, 225, 205, 225};
        int[] yp2 = {5, 5, 25, 25};
        int[] xp3 = {205, 225, 205, 225};
        int[] yp3 = {85, 85, 105, 105};
        g.setColor(Color.BLUE);
        g.drawPolygon(xp, yp, 4);
        g.fillPolygon(xp, yp, 4);
        g.drawPolygon(xp2, yp2, 4);
        g.fillPolygon(xp2, yp2, 4);
        g.drawPolygon(xp3, yp3, 4);
        g.fillPolygon(xp3, yp3, 4);
        //zawory odplywowe
        int[] xp4 = {270, 290, 290, 320, 325, 320, 300, 300, 320, 325, 320, 300,
                300, 320, 325, 320, 290, 290, 270};
        int[] yp4 = {50, 50, 10, 10, 15, 20, 20, 50, 50, 55, 60, 60, 90, 90, 95, 100, 100, 60, 60};
        l = xp4.length;
        GeneralPath gp3 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 2);
        gp3.moveTo(xp4[0], yp4[0]);
        for (int k = 1; k < l; k++)
            gp3.lineTo(xp4[k], yp4[k]);
        g.setColor(Color.BLUE);
        g.draw(gp3);
        //zawory
        int[] xp5 = {315, 335, 315, 335};
        int[] yp5 = {5, 5, 25, 25};
        int[] xp6 = {315, 335, 315, 335};
        int[] yp6 = {45, 45, 65, 65};
        int[] xp7 = {315, 335, 315, 335};
        int[] yp7 = {85, 85, 105, 105};
//		g.setColor(Color.);
        g.drawPolygon(xp5, yp5, 4);
        g.fillPolygon(xp5, yp5, 4);
        g.drawPolygon(xp6, yp6, 4);
        g.fillPolygon(xp6, yp6, 4);
        g.drawPolygon(xp7, yp7, 4);
        g.fillPolygon(xp7, yp7, 4);

        //gp.closePath();
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
