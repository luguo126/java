import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


class Myservice {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;

	public void produce() {
		try {
			lock.lock();
			while(hasValue == true) {
				condition.await();
			}
			System.out.println("produced an item..");
			hasValue = true;
			condition.signal();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	} //end producer()


	public void consume() {
		try {
			lock.lock();
			while(hasValue == false) {
				condition.await();
			}
			System.out.println(".. consumed an item");
			hasValue = false;
			condition.signal();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	} //end consume()
} // end class Myservice




class MythreadA extends Thread {
	private Myservice service;

	public MythreadA(Myservice service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			service.produce();
		}
	}
} // end class MythreadA


class MythreadB extends Thread {
	private Myservice service;

	public MythreadB(Myservice service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			service.consume();
		}
	}
}


public class ProducerConsumer {
	public static void main(String[] args) {
		Myservice service = new Myservice();

		MythreadA a = new MythreadA(service);
		a.start();
		MythreadB b = new MythreadB(service);
		b.start();
	}
}


