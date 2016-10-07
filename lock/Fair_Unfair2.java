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
			System.out.println("Thread name = "
				+ Thread.currentThread().getName() + " got lock");
		}finally {
			lock.unlock();
		}
	} // end serviceMethod()
} // end class Service


public class Fair_Unfair2 {
	public static void main(String[] args) throws InterruptedException{
		final Service service = new Service(false);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " is ready ..");
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
	}
}
