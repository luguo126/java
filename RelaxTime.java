
class Mythread extends Thread {
	@Override
	public void run() {
		try{
			int time_interval = 0;
			time_interval = (int)(Math.random() * 6);
			Thread.sleep(time_interval * 1000);
			System.out.println(Thread.currentThread().getName() + 
				" rested" + " " + time_interval + " seconds");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Myrunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + 
			": No break");
	}
}


public class RelaxTime {
	public static void main(String[] args) {
		Mythread threadA = new Mythread();
		Mythread threadC = new Mythread();

		Runnable runnable = new Myrunnable();
		Thread threadB = new Thread(runnable);

		threadA.setName("bankClerk-A");
		threadB.setName("bankClerk-B");
		threadC.setName("bankClerk-C");

		threadA.start();
		threadC.start();
		threadB.start();
	}

}
