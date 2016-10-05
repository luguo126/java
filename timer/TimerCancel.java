import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TimerCancel {

	private static Timer timer = new Timer();

	public static class MyTaskA extends TimerTask {
		@Override
		public void run() {
			System.out.println("task A begin: "
				+ new Date().toLocaleString());
			timer.cancel();
		}
	}

	public static class MyTaskB extends TimerTask {
		@Override
		public void run() {
			System.out.println("task B begin: "
				+ new Date().toString());
		}
	}

	
	public static void main(String[] args) throws ParseException{
		MyTaskA taskA = new MyTaskA();
		MyTaskB taskB = new MyTaskB();

		SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
		String dateStr = "2016-10-4 20:13:00";
		Date dateRef = sdf.parse(dateStr);
		System.out.println("date string: " + dateStr);
		System.out.println("current time: "
			+ new Date().toLocaleString());
		
		timer.schedule(taskA, dateRef, 4000);
		timer.schedule(taskB, dateRef, 4000);

	}
}
