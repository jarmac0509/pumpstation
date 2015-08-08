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
	TachometerPanel pobr;
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
JButton b1=new JButton("auto");

b1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent event) {		
		flag=!flag;
		if(flag)
		{b1.setBackground(Color.RED);
		pobr.ob1.auto();
		pobr.ob2.auto();
		pobr.ob3.auto();}
		else
		b1.setBackground(null);
	
	}
	});
JButton b2=new JButton("wz");
b2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent event) {
		//String ans=JOptionPane.showInputDialog(null,"tytul","podaj wartosc zadana");
		//int pzadane=Integer.parseInt(ans);
		ptasked=c.ptasked();
		System.out.println("ptasked=" + ptasked);
	}
});
JButton b3=new JButton("manual");
JButton b4=new JButton("reset");
this.add(b1,"0 0 f");
this.add(b3,"0 2 f");
this.add(b2,"2 0 f");
this.add(b4,"2 2 f");
	}
	
}


