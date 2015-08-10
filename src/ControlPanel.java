import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import layout.TableLayout;

public class ControlPanel extends JPanel{
	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGHT = 100;
	Pressure c;
	int ptasked=0;
	boolean flag=false;
	boolean flag3=false;
	boolean flag4=false;
	TachometerPanel pobr;
	JButton b1,b2,b3,b4;
	public int gettasked(){
		return ptasked;
	}
	ControlPanel(TachometerPanel po,Pressure p){
		pobr=po;
		c=p;
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	double[][] size=new double[2][2];
	for(int i=0;i<2;i++)
		for(int j=0;j<2;j++)
	size[i][j]=TableLayout.PREFERRED;
TableLayout lay=new TableLayout(size);
setLayout(lay);
lay.insertColumn(1, 20);
lay.insertRow(1, 20);
b1=new JButton("auto");

b1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent event) {		
		flag=!flag;
		if(flag)
		{b1.setBackground(Color.RED);
		b4.setBackground(null);
		b3.setBackground(null);
		pobr.ob1.auto();
		pobr.ob2.auto();
		pobr.ob3.auto();
		c.start();
		}
		else
		{b1.setBackground(null);

		//pobr.ob1.stop();
		//pobr.ob2.stop();
		//pobr.ob3.stop();
		//c.reset();
		
		}
	
	}
	});
b2=new JButton("wz");
b2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent event) {
		//String ans=JOptionPane.showInputDialog(null,"tytul","podaj wartosc zadana");
		//int pzadane=Integer.parseInt(ans);
		ptasked=c.ptasked();
		System.out.println("ptasked=" + ptasked);
	}
});
b3=new JButton("manual");
b3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent event) {		
		flag3=!flag3;
		if(flag3)
		{b3.setBackground(Color.RED);
		b4.setBackground(null);
		b1.setBackground(null);
		//pobr.ob1.stop();
		//pobr.ob2.stop();
		//pobr.ob3.stop();
		//c.reset();
		}
		else{
		b3.setBackground(null);
		b4.setBackground(null);
		
		}
	}
	});
b4=new JButton("reset");
b4.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent event) {		
		flag4=!flag4;
		if(flag4)
		{b4.setBackground(Color.RED);
		b1.setBackground(null);
		b3.setBackground(null);
		pobr.ob1.stop();
		pobr.ob2.stop();
		pobr.ob3.stop();
		c.reset();
		}
		else{
		b4.setBackground(null);
		
		}
	}
	});
this.add(b1,"0 0 f");
this.add(b3,"0 2 f");
this.add(b2,"2 0 f");
this.add(b4,"2 2 f");
	}
	
}


