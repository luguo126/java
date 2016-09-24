class Tortoise extends Thread {
	@Override 
	public void run() {
		long timer_begin = System.currentTimeMillis();
		long timer_end = 0L;
		long timediff = 0L;

		try {
			for(int i = 0; i < 50; i++) {
				System.out.println("乌龟跑了1米");
				Thread.sleep(1000);
			}

			timer_end = System.currentTimeMillis();
			timediff = timer_end - timer_begin;
			System.out.println("乌龟到达终点,用时: " + timediff);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class Rabbit implements Runnable {
	@Override
	public void run() {
		long timer_begin = System.currentTimeMillis();
		long timer_end = 0L;
		long timediff = 0L;

		try {
			for(int i = 0; i < 50; i++) {
				System.out.println("兔子跑了1米");
				Thread.sleep(1000);
			}

			timer_end = System.currentTimeMillis();
			timediff = timer_end - timer_begin;
			System.out.println("兔子到达终点,用时: " + timediff);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}


public class TortoiseRabbitRace {
	public static void main(String[] args) {
		Tortoise tortoise = new Tortoise();

		Rabbit r = new Rabbit();
		Thread rabbit = new Thread(r);

		tortoise.setPriority(Thread.MAX_PRIORITY);
		rabbit.setPriority(Thread.MIN_PRIORITY);

		rabbit.start();
		tortoise.start();
	}
}









