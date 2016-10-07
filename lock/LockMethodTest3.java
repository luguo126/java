import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


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
			System.out.println(lock.getWaitQueueLength(condition)
				+ " threads waiting condition");
			condition.signal();
		}finally{
			lock.unlock();
		}
	}

}



public class LockMethodTest3 {
	public static void main(String[] args) throws InterruptedException {
		final Service service = new Service();

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.waitMethod();
			}
		};

		Thread[] threadArr = new Thread[10];

		for(int i = 0; i < 10; i++) {
			threadArr[i] = new Thread(runnable);
		}

		for(int i = 0; i < 10; i++) {
			threadArr[i].start();
		}

		Thread.sleep(2000);
		service.notifyMethod();
	}
}
