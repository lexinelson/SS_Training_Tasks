/**
 * Week 1 - Day 4 - Deadlock Task
 */
package com.ss.firstwk.thurs;

/**
 * Class that creates deadlock
 * @author Lexi Nelson
 *
 */
public class DeadLock {
	volatile private Object outer;
	volatile private Object inner;
	private Boolean didFinish;
	
	/**Constructor
	 * @param first object to lock
	 * @param second object to lock
	 */
	public DeadLock(Object o, Object i) {
		outer = o;
		inner = i;
		didFinish = false;
	}

	/**
	 * Lock in one direction
	 */
	private Runnable firstRun = new Runnable() {

		@Override
		public void run() {
			try {
				synchronized (outer) {
					Thread.sleep(100);
					synchronized (inner) {
						System.out.println(inner);
					}
				}
			} catch (Exception e) {	}

		}
	};

	/**
	 * Lock in the other direction
	 */
	private Runnable nextRun = new Runnable() {
		@Override
		public void run() {
				try {
					synchronized (inner) {
						Thread.sleep(100);
						synchronized (outer) {
							System.out.println(outer);
							didFinish = true;
						}
					}
				} catch (Exception e) {}
		}
	};
	
	/**
	 * Run both locks to create deadlock
	 */
	public void runDeadlock() {
		new Thread(firstRun).start();
		new Thread(nextRun).start();
	}
	
	/**
	 * SHOULD NEVER FINISH
	 * @return false
	 */
	public boolean getDidFinish() {
		return didFinish;
	}

}
