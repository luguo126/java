class Mythread extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				int time = (int)(Math.random() * 1000);
				Thread.sleep(time);
				System.out.println(Thread.currentThread().getName()
					+ " " + "occupys CPU.");
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	} 
}



public class RunThread {
	public static void main(String[] args) {
		try {
			Mythread threadA = new Mythread();
			threadA.setName("thread-A");
			threadA.start();
			for(int i = 0; i < 10; i++) {
				int time = (int)(Math.random() * 1000);
				Thread.sleep(time);
				System.out.println(Thread.currentThread().getName()
					+ " " + "occupys CPU.");
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}





























