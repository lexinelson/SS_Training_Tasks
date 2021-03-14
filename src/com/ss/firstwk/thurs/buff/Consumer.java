/**
 * Week 1 - Day 4- Producer Consumer Task
 */
package com.ss.firstwk.thurs.buff;

import java.util.ArrayList;
import java.util.List;

/**
 * Consumer classs for Producer/Consumer Problem
 * @author Lexi Nelson
 *
 */
public class Consumer implements Runnable {

	private SharedShelf store;
	private final Integer shopSpeed = 250;
	private Integer cartSize;
	private List<Object> purchase = new ArrayList<Object>();
	
	/**
	 * Constructor
	 * @param shelf
	 * @param cart
	 */
	public Consumer(SharedShelf shelf, int cart) {
		store = shelf;
		cartSize = cart;
	}
	
	/**
	 * Accesses shelf for cartSize at speed intervals
	 */
	@Override
	public void run() {
		for (int i = 0; i < cartSize; i++) {
			purchase.add(this.store.takeOff());
			try {
				Thread.sleep(shopSpeed);
			} catch (InterruptedException e) {}
		}
	}
	
	/**
	 * @return objects pulled from shelf
	 */
	public List<Object> getPurchase() {
		return purchase;
	}
}
