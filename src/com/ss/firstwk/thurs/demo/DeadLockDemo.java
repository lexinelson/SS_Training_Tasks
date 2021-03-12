/**
 * Week 1 - Day 4 - Deadlock Task
 */
package com.ss.firstwk.thurs.demo;

import com.ss.firstwk.thurs.DeadLock;

/**
 * Deadlock Demo
 * @author Lexi Nelson
 *
 */
public class DeadLockDemo {

	/**
	 * Should not exit program autonomously
	 * @param args
	 */
	public static void main(String[] args) {
		DeadLock dl = new DeadLock("Hello", "Goodbye");
		dl.runDeadlock();
	}

}
