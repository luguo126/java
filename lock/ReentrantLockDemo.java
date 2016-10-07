import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Myservice {
	private Lock lock = new ReentrantLock();
	public void testMethod() {
		lock.lock();
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()
				+ (" " + (i + 1)));
		}
		System.out.println();
		lock.unlock();
	}
}


class Mythread extends Thread {
	private Myservice service;

	public Mythread(Myservice service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
}


public class ReentrantLockDemo {
	public static void main(String[] args) {
		Myservice service = new Myservice();

		Mythread t1 = new Mythread(service);
		Mythread t2 = new Mythread(service);
		Mythread t3 = new Mythread(service);
		Mythread t4 = new Mythread(service);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
