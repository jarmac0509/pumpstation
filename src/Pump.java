import java.awt.*;


import javax.swing.JComponent;

public class Pump extends JComponent{
	private static final int DEFAULT_WIDTH = 132;
	private static final int DEFAULT_HEIGHT = 52;
String name="M";
boolean state=false;
Color col=Color.blue;
Pump(String s){
	name=s;
}
Pump(){
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	setLayout(new BorderLayout());
	
}
public void setActive(){
	state=!state;
	if(state)
	col=Color.red;
	else
		col=Color.blue;
	repaint();
}
public void setInactive(){
	state=false;
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
	g.drawString(name, wspx+13, wspy+27);
}
public Dimension getPreferredSize() {
	return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
}

}
