class Mythread4 extends Thread {
	private int count = 5;

	public Mythread4(String name) {
		super();
		setName(name); // set thread name
	}

	@Override
	public void run() {
		super.run(); 
		while(count > 0) {
			count--;
			System.out.println("computed by " + 
				Thread.currentThread().getName() + 
				" " + "count = " + count);
		}
	}
}


public class RunThread4 {
	public static void main(String[] args) {
		Mythread4 th0 = new Mythread4("th-A");
		Mythread4 th1 = new Mythread4("th-B");
		Mythread4 th2 = new Mythread4("th-C");

		th0.start();
		th1.start();
		th2.start();		
	}
}



