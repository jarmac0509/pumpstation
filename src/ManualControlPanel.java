//import java.awt.GridLayout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ManualControlPanel extends JPanel{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	TachometerPanel po;
	Power pow;
	Pump p1;
	Pump p2;
	Pump p3;
	Manual man;
	boolean f=false;
	ManualControlPanel(TachometerPanel o,Power p,Pump x1,Pump x2,Pump x3){
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    po=o;
    pow=p;
    p1=x1;p2=x2;p3=x3;
	setLayout(null);

	JPanel pumps=new JPanel();
	pumps.setLayout(new BorderLayout());
	
	man=new Manual(p1,p2,p3,pow);
	pumps.add(p1,BorderLayout.WEST);
	pumps.add(p2,BorderLayout.CENTER);
	pumps.add(p3,BorderLayout.EAST);
	add(pumps);
	pumps.setBounds(15, 10,400, 60);
	
	JButton b1=new JButton(" network1 ");
	JButton b2=new JButton(" network2 ");
	JButton b3=new JButton(" network3 ");
	JButton b4=new JButton("converter1");
	JButton b5=new JButton("converter2");
	JButton b6=new JButton("converter3");
	JButton b7=new JButton("+");
	JButton b8=new JButton("-");
	JButton b9=new JButton("+");
	JButton b10=new JButton("-");
	JButton b11=new JButton("+");
	JButton b12=new JButton("-");
	JPanel buttons=new JPanel();
	
	buttons.setBounds(3, 70, 375, 60);
	buttons.setLayout(new GridLayout(2,3,20,5));
	buttons.add(b1);
	buttons.add(b2);
	buttons.add(b3);
	buttons.add(b4);
	buttons.add(b5);
	buttons.add(b6);
	add(buttons);
	JPanel buttons2=new JPanel();
	add(buttons2);
	buttons2.setBounds(3, 130, 375, 20);
	buttons2.setLayout(new GridLayout(1,6,21,0));
	buttons2.add(b7);
	buttons2.add(b8);
	buttons2.add(b9);
	buttons2.add(b10);
	buttons2.add(b11);
	buttons2.add(b12);	

	b1.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent e) {
			po.ob1.network();			
			//p1.setActive();			
		}
	});
	
	b2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			po.ob2.network();
				
		}
	});
	
	b3.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			po.ob3.network();
					
		}
	});
	b4.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			po.ob3.auto();
			//po.pow.start();
			po.ob1.setconverter();		
		}
	});
	b5.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			po.ob3.auto();
			//po.pow.start();
			po.ob2.setconverter();		
		}
	});
	b6.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			po.ob3.auto();
			//po.pow.start();
			po.ob3.setconverter();		
		}
	});
	b7.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			po.ob3.auto();
			//po.pow.start();
			po.ob1.up();
			//p1.setActive();			
		}
	});
	b9.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			po.ob3.auto();
			//po.pow.start();
			po.ob2.up();
			//p2.setActive();			
		}
	});
	b11.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			po.ob3.auto();
			//po.pow.start();
			po.ob3.up();
			//p3.setActive();			
		}
	});
	b8.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			po.ob3.auto();
			//po.pow.start();
			po.ob1.down();
			//p3.setActive();			
		}
	});
	b10.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			po.ob3.auto();
			//po.pow.start();
			po.ob2.down();
			//p3.setActive();			
		}
	});
	b12.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			po.ob3.auto();
			//po.pow.start();
			po.ob3.down();
			//p3.setActive();			
		}
	});
}}
