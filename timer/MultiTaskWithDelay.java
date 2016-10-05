import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class MultiTaskWithDelay {
	private static Timer timer = new Timer();
	
	static public class MyTask extends TimerTask {
		@Override 
		public void run() {
			try{
				System.out.println("task begin time: "
						+ new Date().toLocaleString());
				Thread.sleep(10000);
				System.out.println("task end time: "
						+ new Date().toLocaleString());
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static public class MyTask2 extends TimerTask {
		@Override
		public void run() {
			System.out.println("task2 begin time: "
						+ new Date().toLocaleString());
			System.out.println("task2 end time: "
						+ new Date().toLocaleString());
		}
	}

	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			MyTask2 task2 = new MyTask2();

			SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf2 = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
			String dateString = "2016-10-4 21:35:30";
			String dateString2 = "2016-10-4 21:35:34:";
			Date dateRef = sdf.parse(dateString);
			Date dateRef2 = sdf2.parse(dateString2);
			System.out.println("task supposed to start at: "
						+ dateRef.toLocaleString());
			System.out.println("current time: " + new Date().toLocaleString());
			System.out.println("task2 supposed to start at: " + 
						dateRef2.toLocaleString());
			System.out.println("current time2: " + new Date().toLocaleString());
			
			
			timer.schedule(task, dateRef);
			timer.schedule(task2, dateRef2);
		} catch(ParseException e) {
			e.printStackTrace();
		}
	}
}
