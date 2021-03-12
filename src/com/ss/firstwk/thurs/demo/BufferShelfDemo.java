/**
 * Week 1 - Day 4 - Producer Consumer Task
 */
package com.ss.firstwk.thurs.demo;

import java.util.concurrent.TimeUnit;

import com.ss.firstwk.thurs.buff.Consumer;
import com.ss.firstwk.thurs.buff.Producer;
import com.ss.firstwk.thurs.buff.SharedShelf;

/**
 * Producer Consumer Problem demo
 * @author lexne
 *
 */
public class BufferShelfDemo {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final int operatingHours = 10;
		SharedShelf shelf = new SharedShelf();
		Producer maker = new Producer(shelf, 50);
		Consumer shopper = new Consumer(shelf, 50);
		
		Thread make = new Thread(maker);
		Thread shop = new Thread(shopper);
		
		make.start();
		shop.start();
		
		try {
			TimeUnit.SECONDS.sleep(operatingHours);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Producers made " + maker.getRecords().size() + " units");
		System.out.println("Consumers purchased " + shopper.getPurchase().size() + " units");
		
		for (Boolean item : maker.getRecords())
			if (item == false) {
				System.out.println("But something went wrong with production");
				System.out.println(maker.getRecords());
			}
		for (Object obj : shopper.getPurchase())
			if (obj == null) {
				System.out.println("But something went wrong on the sales floor");
				System.out.println(shopper.getPurchase());
			}
	}

}
