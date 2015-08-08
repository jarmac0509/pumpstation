import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Pompa extends JComponent{
	private static final int DEFAULT_WIDTH = 132;
	private static final int DEFAULT_HEIGHT = 52;
String nazwa="M";
boolean stan=false;
Color col=Color.blue;
Pompa(String s){
	nazwa=s;
}
Pompa(){
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	setLayout(new BorderLayout());
	
}
public void setActive(){
	stan=!stan;
	if(stan)
	col=Color.red;
	else
		col=Color.blue;
	repaint();
}
public void setInactive(){
	stan=false;
	col=Color.blue;
	repaint();
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
	g.drawString(nazwa, wspx+13, wspy+27);
}
public Dimension getPreferredSize() {
	return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
}

}
