class SimpleThread extends Thread {
	public SimpleThread(String str) {
		super(str);
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " " + getName());

			try {
				sleep((int)(Math.random()*1000));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Done! " + getName());
	}
}

public class TwoThreadTest {
	public static void main(String[] args) {
		new SimpleThread("thread-A").start();
		new SimpleThread("Thread-B").start();
	}
}
