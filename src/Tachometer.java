import java.awt.*;


import javax.swing.JButton;
import javax.swing.JPanel;

public class Tachometer extends JPanel {
	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGHT = 100;
	JButton but;
	int pcurrent;
	int ptasked;
	Pressure pa;
	int id,lp1;

	Tachometer(Pressure c, int i) {
		id = i;
		pa = c;
	
	}
public void auto(){
	Runnable rob = new RunTachometer(this);
	Thread w1 = new Thread(rob);
	w1.start();

}
	public void paintComponent(Graphics g1) {
		super.paintComponent(g1); // erase background
		Graphics2D g = (Graphics2D) g1;
		Font f = new Font("SansSerif", Font.BOLD, 16);
		g.setColor(Color.BLUE);
		g.setFont(f);
		int wspx = 0, wspy = 0;
		g.setColor(new Color(208, 207, 232));
		g.fillRect(wspx + 1, wspy + 1, 200, 200);
		g.setColor(new Color(208, 207, 204));
		g.setColor(Color.GREEN);
		g.drawArc(wspx, wspy, 100, 100, 0, 180);
		g.setColor(Color.red);
		g.fillArc(wspx, wspy, 100, 100, 0, 60);
		g.setColor(Color.GREEN);
		g.fillArc(wspx, wspy, 100, 100, 60, 120);
		g.setColor(Color.yellow);
		g.fillArc(wspx, wspy, 100, 100, 120, 180);
		g.drawArc(wspx + 10, wspy + 10, 80, 80, 0, 180);
		g.setColor(Color.white);
		g.fillArc(wspx + 10, wspy + 10, 80, 80, 0, 180);
		g.setColor(new Color(208, 207, 232));
		g.fillArc(wspx, wspy, 100, 100, 0, -180);
		g.setColor(Color.black);
		//g.drawString("60", wspx + 89, wspy + 27);

		double angle;
		int x1, y1, x2, y2;
		for (int i = 6; i <= 12; i++) {
			angle = 2 * Math.PI * (i / 12.0);
			x1 = (int) (50 * Math.cos(angle)) + 50 + wspx;
			y1 = (int) (50 * Math.sin(angle)) + 50 + wspy;
			x2 = (int) (45 * Math.cos(angle)) + 50 + wspx;
			y2 = (int) (45 * Math.sin(angle)) + 50 + wspy;
			g.drawLine(x1, y1, x2, y2);
		}
		for (int i = 30; i <= 60; i++) {
			angle = 2 * Math.PI * (i / 60.0);
			x1 = (int) (50 * Math.cos(angle)) + 50 + wspx;
			y1 = (int) (50 * Math.sin(angle)) + 50 + wspy;
			x2 = (int) (48 * Math.cos(angle)) + 50 + wspx;
			y2 = (int) (48 * Math.sin(angle)) + 50 + wspy;
			g.drawLine(x1, y1, x2, y2);
		}

		angle = 2 * Math.PI * ((pcurrent - 15) / 60.0) - (Math.PI / 2);
		x1 = (int) (40 * Math.cos(angle));
		y1 = (int) (40 * Math.sin(angle));
		g.drawLine(50 + wspx, 50 + wspy, 50 + x1 + wspx, 50 + y1 + wspy);

	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public void update() {
		lp1=pa.getpcurrent();
		if (id == 1 && lp1<= 30) {
			if (pcurrent < lp1)
				for (;  lp1>pcurrent ;) {
					pcurrent++;
					System.out.println("p1 " + pcurrent);
					this.repaint();
					try {
						Thread.sleep(100);
					}

					catch (InterruptedException e) {
					}
				}

			else if (lp1 < pcurrent)
				for (;lp1<pcurrent;) {
					pcurrent--;
					this.repaint();
					System.out.println("p1 " + pcurrent);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}	
		}

		else if (id == 2 && lp1 > 30 && lp1 <= 60) {
		
			if (lp1-30 > pcurrent)

				for (; pcurrent< lp1-30;) {
					pcurrent++;
					this.repaint();
					System.out.println("p2 " + pcurrent);
					try {
						Thread.sleep(100);
					}

					catch (InterruptedException e) {
					}
				}
			else if (lp1-30 <= pcurrent)
				for (;pcurrent>lp1-30 ;) {
					--pcurrent;
					this.repaint();
					System.out.println("p2 " + pcurrent);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
		} 
				
		 else if (id == 3 && lp1 > 60)

		{
			if (lp1-60 > pcurrent)
				for (;pcurrent< lp1-60;) {
					++pcurrent;
					this.repaint();
					System.out.println(pcurrent);
					try {
						Thread.sleep(100);
					}

					catch (InterruptedException e) {
					}
				}

			else if (lp1-60 < pcurrent)
				for (;pcurrent> lp1-60;) {
					pcurrent--;
					this.repaint();
					System.out.println(pcurrent);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
		}
		}
	}


class RunTachometer implements Runnable {
	Tachometer obr;

	RunTachometer(Tachometer o) {
		obr = o;
	}

	public void run() {
		while (true) {
			// System.out.println("teraz aktualizuje");
			obr.update();
			// System.out.println("teraz repainuje");
			// obr.repaint();
		}
	}
}
