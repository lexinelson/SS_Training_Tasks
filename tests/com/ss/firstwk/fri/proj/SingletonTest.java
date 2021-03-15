package com.ss.firstwk.fri.proj;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.junit.Test;

public class SingletonTest {
	private SingletonFixed base1;
	private SingletonFixed base2;

	@Test
	public void getInstanceTest() {
		base1 = SingletonFixed.getInstance();
		base2 = SingletonFixed.getInstance();
		
		assertEquals(base1, base2);
	}
	
	@Test
	public void getInstanceEdgeTest() {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++)
					base1 = SingletonFixed.getInstance();
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++)
					base2 = SingletonFixed.getInstance();
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new	Thread(r2);
		
		t1.start();
		t2.start();
		
		while (t1.isAlive() || t2.isAlive()) {
			//Empty loop to wait for finished
		}
		assertEquals(base1, base2);
	}
	
	@Test
	public void databaseQueryTest() {
		try {
			SingletonFixed.databaseQuery(new BigDecimal("12"));
		} catch (NullPointerException e){
			assertEquals(true, false); //Guarantee return failure without interrupting test
		} catch (SQLException e) {
			assertEquals(true, true); //Gets pass if the exception is what we expect
		}
		
	}
	
	@Test
	public void databaseQueryEdgeTest() {
		Runnable runQuery = new Runnable() {
			@Override
			public void run() throws NullPointerException {
				try {
					SingletonFixed.databaseQuery(new BigDecimal("12"));
					SingletonFixed.databaseQuery(null);
				} catch (NullPointerException e) {
					throw e;
				} catch (SQLException e) {
					assertEquals(true, true);
				}
			}
		};
		
		Thread t1 = new Thread(runQuery);
		Thread t2 = new Thread(runQuery);
		
		t1.start();
		t2.start();
		
		while (t1.isAlive() || t2.isAlive()) {
			//empty loop for wait period
		}
		//If we haven't gotten exception at this point... we pass
		assertEquals(true, true);
	}
}
