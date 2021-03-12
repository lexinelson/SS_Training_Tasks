package com.ss.firstwk.thurs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class DeadLockTest {
	private DeadLock test;
	
	@Test
	public void deadLockTest() {
		Object dummy1 = "Hello";
		Object dummy2 = "Goodbye";
		test = new DeadLock(dummy1, dummy2);
		test.runDeadlock();
		
		assertEquals(false, test.getDidFinish());
	}
	
	@Test
	public void deadLockEdgeTest() {
		test = new DeadLock(null, null);
		test.runDeadlock();
		assertNotEquals(true, test.getDidFinish());
	}
}
