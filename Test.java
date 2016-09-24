class SimpleThread implements Runnable {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
			try {
				Thread.sleep((int)(Math.random()*1000));
			}catch(InterruptedException e){
				e.printStackTrace();;
			}
		}
		
		System.out.println("Done!" + " " + 
				Thread.currentThread().getName());
	}
}


public class Test {
	public static void main(String[] args) {
		// Thread t1 = new Thread("thread-A");
		// Thread t2 = new Thread("thread-B");
		// t1.start();
		// t2.start();
		new Thread(new SimpleThread(), "first").start();
		new Thread(new SimpleThread(), "second").start();
	}
}
