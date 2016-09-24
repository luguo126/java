// Daemon thread
//

class Mythread extends Thread {
	private int i = 0;
	@Override
	public void run() {
		try {
			System.out.println("this.isDaemon() = " + this.isDaemon());
			// err:  System.out.println("Thread.isDaemon() = " + Thread.isDaemon());
			while(true) {
				i++;
				System.out.println("i = " + i);
				Thread.sleep(1000);
			}	
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}    
}


public class DaemonThread {
	public static void main(String[] args) {
		try{
			Mythread thread = new Mythread();
			thread.setDaemon(true);
			thread.start();
			Thread.sleep(5000);
			System.out.println("thread.isDaemon() = " + thread.isDaemon());
			System.out.println("我离开thread对象也不在打印,也就是停止了");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}






