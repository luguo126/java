class PrintString implements Runnable {
	private boolean isContinuePrint = true;
	
	public boolean isContinuePrint(boolean isContunuePrint) {
		return isContinuePrint;
	}

	public void setContinuePrint(boolean isContinuePrint) {
		this.isContinuePrint = isContinuePrint;
	}

	public void printStringMethod() {
		try {
			while (isContinuePrint == true) {
				System.out.println("run printStringMethod(), thread name = " 
					+ Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		printStringMethod();
	}
}


public class RunDeadThread2 {
	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		new Thread(printStringService).start();
		System.out.println("i want to stop it. stopThread = " + 
			Thread.currentThread().getName() );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printStringService.setContinuePrint(false);
	}
}
























