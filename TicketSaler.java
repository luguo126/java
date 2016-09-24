class RailwayStation extends Thread{
	private int ticket_num = 30;

	@Override
	synchronized public void run() {
		while(true) {
			if(ticket_num > 0) {
				ticket_num--;
				System.out.println("remains " + ticket_num + "tickets");
			}else{
				System.out.println("sole out");
				return ;
			}
		}
	}
}


public class TicketSaler {
	public static void main(String[] args) {
		RailwayStation rs = new RailwayStation();
		Thread th1 = new Thread(rs, "station A");
		Thread th2 = new Thread(rs, "station B");
		Thread th3 = new Thread(rs, "station C");
		Thread th4 = new Thread(rs, "station D");
		Thread th5 = new Thread(rs, "station E");

		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
	}
}
