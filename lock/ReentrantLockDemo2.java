import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Myservice {
	private Lock lock = new ReentrantLock();
	
	public void methodA() {
		try {
			lock.lock();
			System.out.println("methodA begin, Thread name = "
				+ Thread.currentThread().getName() + " Time = "
				+ System.currentTimeMillis());
			Thread.sleep(4000);
			System.out.println("methodA end  , Thread name = "
				+ Thread.currentThread().getName() + " Time = "
				+ System.currentTimeMillis());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}  // end methodA()

	public void methodB() {
		try {
			lock.lock();
			System.out.println("methodB begin, Thread name = "
				+ Thread.currentThread().getName() + " Time = "
				+ System.currentTimeMillis());
			Thread.sleep(4000);
			System.out.println("methodB end  , Thread name = "
				+ Thread.currentThread().getName() + " Time = "
				+ System.currentTimeMillis());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	} // end methodB()
}


class ThreadA extends Thread {
	private Myservice service;

	public ThreadA(Myservice service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodA();
	}
} // end class ThreadA

class ThreadAA extends Thread {
	private Myservice service;

	public ThreadAA(Myservice service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodA();
	}
}

class ThreadB extends Thread {
	private Myservice service;

	public ThreadB(Myservice service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}
}

class ThreadBB extends Thread {
	private Myservice service;

	public ThreadBB(Myservice service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}
}


public class ReentrantLockDemo2 {
	public static void main(String[] args) {
		Myservice service = new Myservice();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadAA aa = new ThreadAA(service);
		aa.setName("AA");
		aa.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

		ThreadBB bb = new ThreadBB(service);
		bb.setName("BB");
		bb.start();
	}
}




























