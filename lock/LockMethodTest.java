import java.util.concurrent.locks.ReentrantLock;

class Service {
	private ReentrantLock lock = new ReentrantLock();

	public void serviceMethod() {
		try {
			lock.lock();
			System.out.println("serviceMethod() getHoldCount = "
				+ lock.getHoldCount());
			serviceMethod2();
		}finally{
			lock.unlock();
		}
	} // end serviceMethod()

	public void serviceMethod2() {
		try {
			lock.lock();
			System.out.println("serviceMethod2() getHoldCount = "
				+ lock.getHoldCount());
		} finally {
			lock.unlock();
		}
	} //end serivceMethod2()
}


public class LockMethodTest {
	public static void main(String[] args) {
		Service service = new Service();
		service.serviceMethod();
	}
}
