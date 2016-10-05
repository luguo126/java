import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class TimerCancel2 {
	static int i = 0;

	public static class Mytask extends TimerTask {
		@Override
		public void run() {
			System.out.println("i = " + (i++));
		}
	}


	public static void main(String[] args) {
		while(true) {
			try {
				Timer timer = new Timer();
				Mytask task = new Mytask();
				SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
				String dateString = "2016-10-4 22:25:30";
				Date dateRef = sdf.parse(dateString);		

				timer.schedule(task, dateRef);
				timer.cancel();
			}catch(ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
