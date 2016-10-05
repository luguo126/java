class Myobject {
	private static Myobject instance = null;

	private Myobject() {
		;
	}

	static {
		instance = new Myobject();
	}

	public static Myobject getInstance() {
		return instance;
	}
}


class Mythread extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Myobject.getInstance().hashCode());
		}
	}
}



public class Singleton4 {
	public static void main(String[] args) {
		Mythread th1 = new Mythread();
		Mythread th2 = new Mythread();
		Mythread th3 = new Mythread();

		th1.start();
		th2.start();
		th3.start();
	}
}











