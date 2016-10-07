import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Service {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			condition.await();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void notifyMethod() {
		try {
			lock.lock();
			System.out.println("has threads saiting? " + lock.hasWaiters(condition)
			+ " thead numbers = " + lock.getWaitQueueLength(condition));
			condition.signal();
		}finally {
			lock.unlock();
		}
	}
}



public class LockMethodTest5 {
		public static void main(String[] args) throws InterruptedException {
		final Service service = new Service();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.waitMethod();
			}
		};
		Thread[] threadArray = new Thread[10];
		for(int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for(int i = 0; i < 10; i++) {
			threadArray[i].start();
		}

		Thread.sleep(2000);
		service.notifyMethod();
	}
}












