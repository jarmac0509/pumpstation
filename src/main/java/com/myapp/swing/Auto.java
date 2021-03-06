package com.myapp.swing;

import java.awt.*;

public class Auto {
	int powtasked;
	int powcurrent;
	int extpow;
	boolean f;
	com.myapp.swing.Pump pu1, pu2, pu3;
	com.myapp.swing.Power pow;
	Runnable runadj;
	Thread t;

	Auto(com.myapp.swing.Pump p1, com.myapp.swing.Pump p2, com.myapp.swing.Pump p3, com.myapp.swing.Power p) {
		pow = p;
		pu1 = p1;
		pu2 = p2;
		pu3 = p3;
	}

	public void start() {
		f = true;
		runadj = new RunAdjust();
		t = new Thread(runadj);
		t.start();
	}

	public void stop() {
		f = false;

	}

	public void draw() {
		powcurrent = pow.getpowcurrent();
		System.out.println("com.myapp.swing.Auto draw powcurrent " + powcurrent);
		if (powcurrent == 0) {
			pu1.col = Color.blue;
			pu1.repaint();
		}
		if (powcurrent > 0 && powcurrent < 30) {
			pu1.col = Color.red;
			pu1.repaint();
			pu2.col = Color.blue;
			pu2.repaint();
			pu3.col = Color.blue;
			pu3.repaint();
		} else if (powcurrent > 30 && powcurrent < 60) {
			pu2.col = Color.red;
			pu2.repaint();
			pu3.col = Color.blue;
			pu3.repaint();
		} else if (powcurrent > 60) {
			pu3.col = Color.red;
			pu3.repaint();
		}
	}

	public void adjust() {
		extpow = pow.getpowcurrent();
		System.out.println("com.myapp.swing.Auto adjust extpow" + extpow);
		if (extpow <= 30) {
			pu1.setpowcurrent(extpow);
			draw();
		}
		if (extpow > 30 && extpow <= 60) {
			pu2.setpowcurrent(extpow);
			draw();
		}
		if (extpow > 60) {
			pu3.setpowcurrent(extpow);
			draw();
		}
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
		}

	}

	private class RunAdjust implements Runnable {

		public void run() {
			while (f)
				adjust();

		}
	}
}
