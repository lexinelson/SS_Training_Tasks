package com.ss.firstwk.thurs;

public class DeadLock {
	volatile private Object outer;
	volatile private Object inner;
	private Boolean didFinish;
	
	public DeadLock(Object o, Object i) {
		outer = o;
		inner = i;
		didFinish = false;
	}

	private Runnable firstRun = new Runnable() {

		@Override
		public void run() {
			try {
				synchronized (outer) {
					Thread.sleep(100);
					synchronized (inner) {
						System.out.println("We got to the first run!");
					}
				}
			} catch (Exception e) {	}

		}
	};

	private Runnable nextRun = new Runnable() {
		@Override
		public void run() {
				try {
					synchronized (inner) {
						Thread.sleep(100);
						synchronized (outer) {
							System.out.println("We got to the second run!");
							didFinish = true;
						}
					}
				} catch (Exception e) {}
		}
	};
	
	public void runDeadlock() {
		new Thread(firstRun).start();
		new Thread(nextRun).start();
	}
	
	public boolean getDidFinish() {
		return didFinish;
	}

}
