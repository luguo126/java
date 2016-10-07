import java.util.concurrent.locks.ReentrantLock;

class Service {
	public ReentrantLock lock = new ReentrantLock();

	public void serviceMethod() {
		try {
			lock.lock();
			System.out.println("Thread name = "
				+ Thread.currentThread().getName());
			Thread.sleep(4000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	} // end serviceMethod()
} // end class Service


public class LockMethodTest2 {
	public static void main(String[] args) throws InterruptedException {
		final Service service = new Service();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.serviceMethod();
			}
		};

		Thread[] threadArray = new Thread[10];
		for(int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(runnable);
		}

		for(int i = 0; i < 10; i++) {
			threadArray[i].start();
		}

		Thread.sleep(3000);
		System.out.println("thread numbers: "
			+ service.lock.getQueueLength() + " waiting to get lock..");
	}
}
