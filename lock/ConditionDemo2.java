import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Myservice {
	private Lock lock = new ReentrantLock();
	public Condition conditionA = lock.newCondition();
	public Condition conditionB = lock.newCondition();

	public void awaitA() {
		try {
			lock.lock();
			System.out.println("begin awaitA(): " + System.currentTimeMillis()
				+ " ThreadName = " + Thread.currentThread().getName());
			conditionA.await();
			System.out.println("end   awaitA(): " + System.currentTimeMillis()
				+ " ThreadName = " + Thread.currentThread().getName());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	} // end awaitA()


	public void awaitB() {
		try {
			lock.lock();
			System.out.println("begin awaitB()): " + System.currentTimeMillis()
				+ " ThreadName = " + Thread.currentThread().getName());
			conditionB.await();
			System.out.println("end   awaitB(): " + System.currentTimeMillis()
				+ " ThreadName = " + Thread.currentThread().getName());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	} // end awaitB()

	
	public void signalAll_A() {
		try {
			lock.lock();
			System.out.println("signalAll_A(): " + System.currentTimeMillis()
				+ " ThreadName = " + Thread.currentThread().getName());
			conditionA.signalAll();
		}finally {
			lock.unlock();
		}
	} //end signalAll_A()

	
	public void signalAll_B() {
		try {
			lock.lock();
			System.out.println("signalAll_B(): " + System.currentTimeMillis()
				+ " ThreadName = " + Thread.currentThread().getName());
			conditionB.signalAll();
		}finally {
			lock.unlock();
		}
	} //end signalAll_B()

} // end class Myservice



class ThreadA extends Thread {
	private Myservice service;

	public ThreadA(Myservice service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.awaitA();
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
		service.awaitB();
	}
}


public class ConditionDemo2 {
	public static void main(String[] args) throws InterruptedException{
		Myservice service = new Myservice();
		ThreadA a = new ThreadA(service);
		a.setName("th-A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("th-B");
		b.start();

		Thread.sleep(3000);
		service.signalAll_A();
	}
} 










