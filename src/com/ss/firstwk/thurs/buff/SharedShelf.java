/**
 * Week 1 - Day 4 - Producer Consumer Task
 */
package com.ss.firstwk.thurs.buff;

import java.util.List;

/**
 * Buffered Array (shelf) class
 * @author Lexi Nelson
 *
 */
public class SharedShelf {
	private final int size = 12;
	private Object[] shelf;
	private volatile Integer front;
	
	/**
	 * Constructor
	 */
	public SharedShelf() {
		shelf = new Object[size];
		front = -1;
	}
	
	/**
	 * lock on front of the shelf
	 * @param isProducer
	 * @return front
	 */
	private synchronized Integer getFront(boolean isProducer) {
		Integer location = null;
		if (isProducer) {
			while (front >= shelf.length - 1)
				try {
					this.wait();
				} catch (InterruptedException e) {}
			location = ++front;
		}
		else {
			while (front < 0)
				try {
					this.wait();
				} catch (InterruptedException e) {}
			location = front--;
		}
		this.notifyAll();
		return location;
	}
	
	/**
	 * Consumer method for taking from shelf
	 * @return object on shelf
	 */
	public Object takeOff() {
		Integer location = getFront(false);
		if (shelf[location] != null) {
			Object temp = shelf[location];
			shelf[location] = null;
			return temp;
		}
		return null;
	}
	
	/**
	 * Producer method for adding to shelf
	 * @param item
	 * @return whether or not it worked
	 */
	public boolean putUp(Object item) {
		Integer location = getFront(true);
		if (shelf[location] == null) {
			shelf[location] = item;
			return true;
		}
		return false;
	}
}
