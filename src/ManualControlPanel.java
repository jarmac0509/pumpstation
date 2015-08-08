//import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import layout.TableLayout;

public class ManualControlPanel extends JPanel{
	private static final int DEFAULT_WIDTH = 150;
	private static final int DEFAULT_HEIGHT = 200;
	ManualControlPanel(){
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

			double[][] size=new double[2][3];
			for(int i=0;i<2;i++)
				for(int j=0;j<3;j++)
			size[i][j]=TableLayout.PREFERRED;
	TableLayout lay=new TableLayout(size);
	setLayout(lay);

	
	Pump p1=new Pump("P1");	
	Pump p2=new Pump("P2");
	Pump p3=new Pump("P3");
	add(p1,"0 0 c");
	add(p2,"1 0 c");
	add(p3,"2 0 c");
	
	
	JButton b1=new JButton("network1");
	JButton b2=new JButton("network2");
	JButton b3=new JButton("network3");
	JButton b4=new JButton("converter1");
	JButton b5=new JButton("converter2");
	JButton b6=new JButton("converter3");
	b4.setBounds(200,330 , 60, 20);
	b1.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			p1.setActive();			
		}
	});
	
	b2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			p2.setActive();			
		}
	});
	
	b3.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			p3.setActive();			
		}
	});
	this.add(b1,"0 1 l");
	this.add(b2,"1 1 l");
	this.add(b3,"2 1 l");
	this.add(b4,"0 2 l");
	this.add(b5,"1 2 l");
	this.add(b6,"2 2 l");
}}
