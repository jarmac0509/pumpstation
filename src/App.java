import java.awt.EventQueue;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
        {
           public void run()
           {
		JFrame frame = new Combo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("pompownia");
           }
        });
  }
}

class Combo extends JFrame {
	private static final int DEFAULT_WIDTH = 600;
	private static final int DEFAULT_HEIGHT = 480;
	public Combo() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//		setLayout(new BorderLayout(30,0));
		setLayout(null);
		
		
		Pressure p=new Pressure();
		TachometerPanel obpanel=new TachometerPanel(p);
		ControlPanel ps=new ControlPanel(obpanel,p);
		PressureIndicator wsk=new PressureIndicator(p);
		ManualControlPanel psr=new ManualControlPanel();
		Scheme scheme=new Scheme();
		add(scheme);
		add(ps);	
		add(obpanel);	
		add(psr);
		add(wsk);
		scheme.setBounds(180, 40, 350, 112);
		obpanel.setBounds(150, 160, 400, 120);
		ps.setBounds(10, 308, 180, 100);
		psr.setBounds(195, 310, 350, 250);
		wsk.setBounds(4, 15, 50, 220);
	
		
//pack();
	}
}
