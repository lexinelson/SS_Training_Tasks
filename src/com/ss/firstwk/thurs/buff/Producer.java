package com.ss.firstwk.thurs.buff;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable {
	
	private SharedShelf productionShelf;
	private final int productionRate = 250;
	private Integer quota;
	private List<Boolean> records = new ArrayList<Boolean>();

	public Producer(SharedShelf shelf, int quota) {
		productionShelf = shelf;
		this.quota = quota;
	}
	
	@Override
	public void run() {
		Integer item = (int) (1 + Math.random() * 99);
		for (int i = 0; i < quota; i++) {
			records.add(this.productionShelf.putUp(item));
			try {
				Thread.sleep(productionRate);
			} catch (InterruptedException e) {}
		}
	}
	
	public List<Boolean> getRecords() {
		return records;
	}
}
