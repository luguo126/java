class Mythread extends Thread {
	volatile public static int count;

	synchronized private static void addCount() {
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count = " + count);
	}	

	@Override
	public void run() {
		addCount();
	}
} 


public class VolatileTest2 {
	public static void main(String[] args) {
		Mythread[] threadArr = new Mythread[100];

		for (int i = 0; i < 100; i++) {
			threadArr[i] = new Mythread();
		}

		for (int i = 0; i < 100; i++) {
			threadArr[i].start();
		}
	}
}
