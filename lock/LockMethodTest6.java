import java.util.concurrent.locks.ReentrantLock;

class Service {
	private ReentrantLock lock;
	public Service(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void serviceMethod() {
		try {
			lock.lock();
			System.out.println("fair lock: " + lock.isFair());
		}finally {
			lock.unlock();
		}
	}
}


public class LockMethodTest6 {
	public static void main(String[] args) throws InterruptedException {
		final Service service = new Service(true);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service.serviceMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();


		final Service service2 = new Service(false);
		runnable = new Runnable() {
			@Override
			public void run() {
				service2.serviceMethod();
			}
		};

		thread = new Thread(runnable);
		thread.start();
	} 
}

















