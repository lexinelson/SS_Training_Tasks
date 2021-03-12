/**
 * Week 1 - Day 4 - Producer Consumer Problem
 */
package com.ss.firstwk.thurs.buff;

import java.util.ArrayList;
import java.util.List;

/**
 * Producer Class for Buffered Shelf task
 * @author Lexi Nelson
 *
 */
public class Producer implements Runnable {
	
	private SharedShelf productionShelf;
	private final int productionRate = 250;
	private Integer quota;
	private List<Boolean> records = new ArrayList<Boolean>();

	/**
	 * Constructor
	 * @param shelf
	 * @param quota
	 */
	public Producer(SharedShelf shelf, int quota) {
		productionShelf = shelf;
		this.quota = quota;
	}
	
	/**
	 * Adds to shelf for quota at rate interval
	 */
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
	
	/**
	 * @return record of success or failure
	 */
	public List<Boolean> getRecords() {
		return records;
	}
}
