import java.util.ArrayList;
import java.util.List;


class Mylist {
	private List list = new ArrayList();

	public void add() {
		list.add("list element");
	}

	public int size() {
		return list.size();
	}
}


class ThreadA extends Thread {
	private Mylist mylist;

	public ThreadA(Mylist mylist) {
		this.mylist = mylist;
	}

	@Override
	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				mylist.add();
				System.out.println("add " + (i+1) + " elements");
				Thread.sleep(3000);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}



class ThreadB extends Thread {
	private Mylist mylist;

	public ThreadB(Mylist mylist) {
		super();
		this.mylist = mylist;
	}

	@Override
	public void run() {
		try {
			while(true) {
				if (mylist.size() == 3) {  // not capture this condition. ???
					System.out.println("size == 3. thread-B exiting");
					throw new InterruptedException();
				}
			}
		}catch (InterruptedException e) {
				e.printStackTrace();	
		}
	}
}



public class Communication {
	public static void main(String[] args) {
		Mylist service = new Mylist();
		ThreadA thA = new ThreadA(service);
		thA.setName("th-A");
		thA.start();
		ThreadB thB = new ThreadB(service);
		thB.setName("th-B");
		thB.start();
		
	}
}




