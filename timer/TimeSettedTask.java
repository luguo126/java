import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


class MyTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("executing task here...");
	}
}

public class TimeSettedTask {
	public  static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 1000, 2000);
	}
}
