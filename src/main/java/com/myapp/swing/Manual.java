package com.myapp.swing;

import java.awt.*;

public class Manual {

	int powtasked;
	int powcurrent;
	int localpow;
	com.myapp.swing.Pump pu1,pu2,pu3;
	com.myapp.swing.Power pow;
	Runnable runadj;
	Thread t;
		Manual(com.myapp.swing.Pump p1, com.myapp.swing.Pump p2, com.myapp.swing.Pump p3, com.myapp.swing.Power p){
			pow=p;
			pu1=p1;pu2=p2;pu3=p3;
		}
		public void start(){
			runadj=new RunAdjust();
			t=new Thread(runadj);
			t.start();
		}
		public void draw(){
			powcurrent=pow.getpowcurrent();
			System.out.println("draw=" +powcurrent);
			if(powcurrent==0){
				pu1.col=Color.blue;
			    pu1.repaint();}
			else if(powcurrent>0&&powcurrent<30){
				pu1.col=Color.red;
			    pu1.repaint();
			    pu2.col=Color.blue;
			    pu2.repaint();
			    pu3.col=Color.blue;
			    pu3.repaint();}
			else if(powcurrent>30&&powcurrent<60){
				pu2.col=Color.red;
			    pu2.repaint();
			    pu3.col=Color.blue;
			    pu3.repaint();}
			else if(powcurrent>60){
				pu3.col=Color.red;
			    pu3.repaint();}
		}
		public void network(String pump){	
		if(pump=="P1"){pu1.col=Color.RED;pu1.repaint();
		if (localpow<30)
			for (; localpow < 30;) {
				localpow++;
				pu1.setpowcurrent(localpow);
				System.out.println("localpow1 "+localpow);
				try {
					Thread.sleep(150);
				}

				catch (InterruptedException e) {
				}
			}
		else
			for (; localpow > 0;) {
				localpow--;
				pu1.setpowcurrent(localpow);
				System.out.println("localpow1 "+localpow);
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}//pu1.col=Color.BLUE;pu1.repaint();
		}
		
		if(pump=="P2"){
			if (localpow<30)
				for (; localpow < 30;) {
					localpow++;
					pu2.setpowcurrent(localpow);
					System.out.println("localpow1 "+localpow);
					try {
						Thread.sleep(150);
					}

					catch (InterruptedException e) {
					}
				}
			else
				for (; localpow > 0;) {
					localpow--;
					pu2.setpowcurrent(localpow);
					System.out.println("localpow1 "+localpow);
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
					}
				}
			}
		if(pump=="P3"){
			if (localpow<30)
				for (; localpow < 30;) {
					localpow++;
					pu3.setpowcurrent(localpow);
					System.out.println("localpow1 "+localpow);
					try {
						Thread.sleep(150);
					}

					catch (InterruptedException e) {
					}
				}
			else
				for (; localpow > 0;) {
					localpow--;
					pu3.setpowcurrent(localpow);
					System.out.println("localpow1 "+localpow);
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
					}
				}
			}
		}
		private class RunAdjust implements Runnable{
			

			public void run(){
				while(true);
			   // draw();
				
			}
			}
			}
