import java.util.Random;

public class Pressure {
	int pcurrent;
	int ptasked;
	boolean fin;
	Runnable rws;
	Thread t;

		Pressure(){
			rws = new RunPointer();
			
		}
		public void reset(){			
			fin=true;
			pcurrent=0;
			ptasked=0;
		}
		public void start(){
			fin=false;
			Thread t = new Thread(rws);
			t.start();
		}
		public void update() {
		if (ptasked >pcurrent)
			for (; pcurrent < ptasked;) {
				pcurrent++;
				System.out.println("pc "+pcurrent);
				try {
					Thread.sleep(150);
				}

				catch (InterruptedException e) {
				}
			}
		else if (ptasked <pcurrent)
			for (; pcurrent > ptasked;) {
				pcurrent--;
				System.out.println("pc "+pcurrent);
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}
}
		public int getpcurrent(){return pcurrent;}
		public int ptasked(){
			ptasked = new Random().nextInt(90);
			return ptasked;
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
