import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Scheme extends JPanel{
	

		private static final int DEFAULT_WIDTH = 300;
		private static final int DEFAULT_HEIGHT = 200;
int[]wsp=new int[100];
	Scheme(){
	
	}

	public void paintComponent(Graphics g1) {
		super.paintComponent(g1); // erase background
		Graphics2D g = (Graphics2D) g1;
		Font f = new Font("SansSerif", Font.BOLD, 14);
		g.setColor(Color.blue);
		g.setFont(f);
		int wspx = 0, wspy = 0;
		
		g.drawRect(wspx+10, wspy+10, 80, 90);
		g.fillRect(wspx+10, wspy+10, 80, 90);
		g.setColor(Color.BLACK);
		g.drawString("Container", wspx+12, wspy+60);
		g.drawLine(90+wspx, 50+wspy, 110+wspx, 50+wspy);//---
		g.drawLine(90+wspx, 60+wspy, 110+wspx, 60+wspy);//---
    	g.drawLine(110+wspx, 50+wspy, 110+wspx, 10+wspy);//|
		g.drawLine(110+wspx, 60+wspy, 110+wspx, 100+wspy);//|
		g.drawLine(110, 10, 150, 10);//---
		g.drawLine(110, 100, 150, 100);//---
		g.drawLine(120+wspx, 50+wspy, 150+wspx, 50+wspy);//---
		g.drawLine(120+wspx, 60+wspy, 150+wspx, 60+wspy);//---
		g.drawLine(120+wspx, 50+wspy, 120+wspx, 20+wspy);//|
		g.drawLine(120+wspx, 60+wspy, 120+wspx, 90+wspy);//|
		g.drawLine(120, 20, 150, 20);//---
		g.drawLine(120, 90, 150, 90);//---
		g.drawOval(150, 0, 30, 30);
		g.drawOval(150, 40, 30, 30);
		g.drawOval(150, 80, 30, 30);
		g.drawLine(180+wspx, 50+wspy, 240+wspx, 50+wspy);//---
		g.drawLine(180+wspx, 60+wspy, 240+wspx, 60+wspy);//---
		g.drawLine(250+wspx, 50+wspy, 250+wspx, 10+wspy);//|
		g.drawLine(250+wspx, 60+wspy, 250+wspx, 100+wspy);//|
		g.drawLine(250, 10, 180, 10);//---
		g.drawLine(250, 100, 180, 100);//---
		g.drawLine(240+wspx, 50+wspy, 240+wspx, 20+wspy);//|
		g.drawLine(240+wspx, 60+wspy, 240+wspx, 90+wspy);//|
		g.drawLine(250+wspx, 50+wspy, 270+wspx, 50+wspy);//---
		g.drawLine(250+wspx, 60+wspy, 270+wspx, 60+wspy);//---
		g.drawLine(240, 20, 180, 20);//---
		g.drawLine(240, 90, 180, 90);//---
	}
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	}
