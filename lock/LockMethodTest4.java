import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


class Service {
	public ReentrantLock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			Thread.sleep(8000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}


public class LockMethodTest4 {
	public static void main(String[] args) throws InterruptedException {
		final Service service = new Service();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.waitMethod();
			}
		};

		Thread thA = new Thread(runnable);
		thA.start();
		Thread.sleep(500);
		Thread thB = new Thread(runnable);
		thB.start();
		Thread.sleep(500);

		System.out.println(service.lock.hasQueuedThread(thA));
		System.out.println(service.lock.hasQueuedThread(thB));
		System.out.println(service.lock.hasQueuedThreads());
	}
}
