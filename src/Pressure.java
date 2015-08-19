import java.util.Random;

public class Pressure {
	int pcurrent;
	int ptasked;
	boolean fin;
	Runnable rws;
	Thread t;

		Pressure(){		
		}
		public void reset(){			
		
			pcurrent=0;
			ptasked=0;
		}
		public void start(){
			fin=false;
			Thread t = new Thread(rws);
			t.start();
		}
		public int getpcurrent(){return pcurrent;}
		public void setpcurrent(int x) {
			pcurrent=x;
		};

		public int ptasked(){
			ptasked = new Random().nextInt(90);
			return ptasked;

}
}