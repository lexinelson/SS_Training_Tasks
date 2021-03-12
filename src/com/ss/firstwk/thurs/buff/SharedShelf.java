package com.ss.firstwk.thurs.buff;

import java.util.List;

public class SharedShelf {
	private final int size = 12;
	private Object[] shelf;
	private volatile Integer front;
	
	public SharedShelf() {
		shelf = new Object[size];
		front = -1;
	}
	
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
	
	public Object takeOff() {
		Integer location = getFront(false);
		if (shelf[location] != null) {
			Object temp = shelf[location];
			shelf[location] = null;
			return temp;
		}
		return null;
	}
	
	public boolean putUp(Object item) {
		Integer location = getFront(true);
		if (shelf[location] == null) {
			shelf[location] = item;
			return true;
		}
		return false;
	}
}
