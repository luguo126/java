class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + 
			" " + "is running...");
	}
}


public class RunThread3 {
	public static void main(String[] args) {
		MyRunnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable);
		thread.start();
		System.out.println(Thread.currentThread().getName() + " " + 
			"is exiting...");
	}
}
