class Myobject {

	private static class MyobjectHandler {
		private static Myobject myobject
			= new Myobject();
	}

	private Myobject() {
		;
	}

	public static Myobject getInstance() {
		return MyobjectHandler.myobject;
	}
}


class Mythread extends Thread {
	@Override
	public void run() {
		System.out.println(Myobject.getInstance().hashCode());
	}
}

public class Singleton3 {
	public static void main(String[] args) {
		Mythread th1 = new Mythread();
		Mythread th2 = new Mythread();
		Mythread th3 = new Mythread();

		th1.start();
		th2.start();
		th3.start();
	}
}
