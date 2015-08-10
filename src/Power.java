public class Power {
	int powcurrent;
	int powtasked;
	boolean fin;
	Pressure p;
	Runnable rws;
	Thread t;

		Power(Pressure x){
			rws = new RunPointer();
			p=x;
			
		}
		public void reset(){			
			fin=true;
			powcurrent=0;
			powtasked=0;
		}
		public void start(){
			fin=false;
			Thread t = new Thread(rws);
			t.start();
		}
		public void update() {
		if (powtasked >powcurrent)
			for (; powcurrent < powtasked;) {
				powcurrent++;
				System.out.println("pow "+powcurrent);
				try {
					Thread.sleep(150);
				}

				catch (InterruptedException e) {
				}
			}
		else if (powtasked <powcurrent)
			for (; powcurrent > powtasked;) {
				powcurrent--;
				System.out.println("pow "+powcurrent);
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}
}
		public int getpowcurrent(){return powcurrent;}

		public void settasked(int a){
			powtasked=a;
		}
private class RunPointer implements Runnable {
RunPointer() {
};

public void run() {
	while (fin!=true) {
		
		update();
//		WskaznikCisnienia.this.repaint();
	}
}
}
}
