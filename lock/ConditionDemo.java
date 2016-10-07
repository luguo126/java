import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


class Myservice {
	private Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();

	public void await() {
		try {
			lock.lock();

			System.out.println(" await: " + System.currentTimeMillis());
			condition.await();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	} 

	public void signal() {
		try {
			lock.lock();
			System.out.println("signal: " + System.currentTimeMillis());
			condition.signal();
		}finally {
			lock.unlock();
		}
	}
}


class ThreadA extends Thread {
	private Myservice service;

	public ThreadA(Myservice service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.await();
	}
}



public class ConditionDemo {
	public static void main(String[] args) throws InterruptedException {
		Myservice service = new Myservice();
		ThreadA a = new ThreadA(service);
		a.start();
		Thread.sleep(3000);
		service.signal();
	}
}



