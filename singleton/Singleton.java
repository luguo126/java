class Myobject {
	private static Myobject myobject = new Myobject();

	private Myobject() {
		;
	}

	public static Myobject getInstance() {
		// can not have other instances
		// getInstance() not synchronized
		// not thread-safe
		return myobject;
	}
}


class Mythread extends Thread {
	@Override
	public void run() {
		System.out.println(Myobject.getInstance().hashCode());
	}
}

public class Singleton {
	public static void main(String[] args) {
		Mythread th1 = new Mythread();
		Mythread th2 = new Mythread();
		Mythread th3 = new Mythread();

		th1.start();
		th2.start();
		th3.start();
	}
}
