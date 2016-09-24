class Mythread extends Thread {
	public Mythread() {
		;
	}

	@Override
	public void run() {
		try{
			for(int i = 0; i < 10; i++) {
				System.out.print(i + "  ");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Done ~");
	}
}


public class PrintNum {
	public static void main(String[] args) {
		Mythread thread = new Mythread();
		thread.start();
	}
}







