package com.ss.firstwk.thurs.buff;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {

	private SharedShelf store;
	private final Integer shopSpeed = 250;
	private Integer cartSize;
	private List<Object> purchase = new ArrayList<Object>();
	
	public Consumer(SharedShelf shelf, int cart) {
		store = shelf;
		cartSize = cart;
	}
	
	@Override
	public void run() {
		Integer item = (int) (1 + Math.random() * 99);
		for (int i = 0; i < cartSize; i++) {
			purchase.add(this.store.takeOff());
			try {
				Thread.sleep(shopSpeed);
			} catch (InterruptedException e) {}
		}
	}
	
	public List<Object> getPurchase() {
		return purchase;
	}
}
