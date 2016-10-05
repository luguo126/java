import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


class Mytask extends TimerTask {
	@Override
	public void run() {
		try {
			System.out.println("task begin time: " + new Date());
			Thread.sleep(2000);
			System.out.println("task end time: " + new Date());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}



public class ScheduledTaskWithDelay {
	public static void main(String[] args) throws ParseException{
		Timer timer = new Timer();
		Mytask task = new Mytask();
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date specifiedDate = sdf.parse("2016-10-5 12:47:20");

		timer.schedule(task, specifiedDate, 3000);
	}
}
