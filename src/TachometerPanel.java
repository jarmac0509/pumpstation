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
	Power pow;
	Pump pu1;
	Pump pu2;
	Pump pu3;
	int getp(){return ptasked*5;}
	TachometerPanel(Pressure c,Power a,Pump p1,Pump p2,Pump p3){	
		p=c;
		pow=a;
		pu1=p1;
		pu2=p2;
		pu3=p3;
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLayout(new FlowLayout(FlowLayout.LEFT,30,30));
ob1=new Tachometer(p,pow,1,pu1);
ob2=new Tachometer(p,pow,2,pu2);
ob3=new Tachometer(p,pow,3,pu3);
add(ob1);
add(ob2);
add(ob3);

	}

}
