class Mythread2 extends Thread {
	private int i;
	public Mythread2(int i) {
		super();
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("computed by" + " " + 
			Thread.currentThread().getName() + ": i = " + i);
	}
}


public class RunThread2 {
	public static void main(String[] args) {
		Mythread2 th1 = new Mythread2(1);
		Mythread2 th2 = new Mythread2(2);
		Mythread2 th3 = new Mythread2(3);
		Mythread2 th4 = new Mythread2(4);
		Mythread2 th5 = new Mythread2(5);
		Mythread2 th6 = new Mythread2(6);
		Mythread2 th7 = new Mythread2(7);
		Mythread2 th8 = new Mythread2(8);
		Mythread2 th9 = new Mythread2(9);
		Mythread2 th10 = new Mythread2(10);
		Mythread2 th11 = new Mythread2(11);
		Mythread2 th12 = new Mythread2(12);
		Mythread2 th13 = new Mythread2(13);
		Mythread2 th14 = new Mythread2(14);
		Mythread2 th15 = new Mythread2(15);
		Mythread2 th16 = new Mythread2(16);
		Mythread2 th17 = new Mythread2(17);
		Mythread2 th18 = new Mythread2(18);
		Mythread2 th19 = new Mythread2(19);
		Mythread2 th20 = new Mythread2(20);


		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
		th7.start();
		th8.start();
		th9.start();
		th10.start();
		th11.start();
		th12.start();
		th13.start();
		th14.start();
		th15.start();
		th16.start();
		th17.start();
		th18.start();
		th19.start();
		th20.start();
	}
}











