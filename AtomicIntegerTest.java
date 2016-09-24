import java.util.concurrent.atomic.AtomicInteger;


class AddCountThread extends Thread {
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("computed by " + Thread.currentThread().getName()
				+ ": " + count.incrementAndGet());
		}
	}
}


public class AtomicIntegerTest {
	public static void main(String[] args) {
		AddCountThread countService = new AddCountThread();

		Thread th1 = new Thread(countService);
		th1.start();
		Thread th2 = new Thread(countService);
		th2.start();
		Thread th3 = new Thread(countService);
		th3.start();
		Thread th4 = new Thread(countService);
		th4.start();
		Thread th5 = new Thread(countService);
		th5.start();
	}
}
