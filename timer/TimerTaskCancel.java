import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskCancel {
	private static Timer timer = new Timer();
	
	static public class MyTask extends TimerTask {
		@Override 
		public void run() {
			System.out.println("task begin time: "
						+ new Date().toLocaleString());
			this.cancel();
		}
	}

	static public class MyTask2 extends TimerTask {
		@Override
		public void run() {
			System.out.println("task2 begin time: "
						+ new Date().toLocaleString());
		}
	}

	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			MyTask2 task2 = new MyTask2();

			SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
			String dateString = "2016-10-4 21:52:50";
			Date dateRef = sdf.parse(dateString);
			System.out.println("task supposed to start at: "
						+ dateRef.toLocaleString());
			System.out.println("current time: " + new Date().toLocaleString());
			System.out.println("task2 supposed to start at: " + 
						dateRef.toLocaleString());
			System.out.println("current time2: " + new Date().toLocaleString());
			
			
			timer.schedule(task, dateRef, 2000);
			timer.schedule(task2, dateRef, 2000);
		} catch(ParseException e) {
			e.printStackTrace();
		}
	}
}
