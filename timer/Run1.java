import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run1 {
	private static Timer timer = new Timer();
	
	static public class MyTask extends TimerTask {
		@Override 
		public void run() {
			System.out.println("task begin time: " + new Date());
		}
	}

	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();

			SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
			String dateString = "2016-10-4 20:15:40";
			Date dateRef = sdf.parse(dateString);
			System.out.println("task supposed to start at: " + dateRef);
			System.out.println("current time: " + new Date());

			timer.schedule(task, dateRef);
		} catch(ParseException e) {
			e.printStackTrace();
		}
	}
}
