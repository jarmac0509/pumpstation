import java.awt.FlowLayout;

import javax.swing.JPanel;

public class TachometerPanel extends JPanel{
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 200;
	Tachometer ob1;
	Tachometer ob2;
	Tachometer ob3;
	public int ptasked;
	Pressure p;
	int getp(){return ptasked*5;}
	TachometerPanel(Pressure c){	
		p=c;
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLayout(new FlowLayout(FlowLayout.LEFT,30,30));
ob1=new Tachometer(p,1);
ob2=new Tachometer(p,2);
ob3=new Tachometer(p,3);
add(ob1);
add(ob2);
add(ob3);

	}

}
