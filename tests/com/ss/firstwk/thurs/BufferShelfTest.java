package com.ss.firstwk.thurs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.ss.firstwk.thurs.buff.Consumer;
import com.ss.firstwk.thurs.buff.Producer;
import com.ss.firstwk.thurs.buff.SharedShelf;

public class BufferShelfTest {
	private SharedShelf testShelf = new SharedShelf();
	private Producer testProducer = new Producer(testShelf, 10);
	private Consumer testConsumer = new Consumer(testShelf, 10);

	@Test (timeout = 30000)
	public void testShelf() {
		
		Thread produce = new Thread(testProducer);
		Thread consume = new Thread(testConsumer);
		
		produce.start();
		consume.start();
		
		while (produce.isAlive() || consume.isAlive()) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {}
		}
		
		for (Boolean result : testProducer.getRecords())
			assertEquals(true, result);
		for (Object item : testConsumer.getPurchase())
			assertNotEquals(null, item);
		
		assertEquals(10, testProducer.getRecords().size());
		assertEquals(10, testConsumer.getPurchase().size());
	}
	
	@Test
	public void testConsumerLimit() {
		Thread consume = new Thread(testConsumer);
		Thread produce = new Thread(new Producer(testShelf, 3));
		consume.start();
		produce.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {	}
		
		for (Object item : testConsumer.getPurchase())
			assertNotEquals(null, item);
		assertEquals(3, testConsumer.getPurchase().size());
	}
	
	@Test
	public void testProducerLimit() {
		Producer edgePro = new Producer(testShelf, 20);
		Thread consume = new Thread(new Consumer(testShelf, 1));
		Thread produce = new Thread(edgePro);
		consume.start();
		produce.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {}
		
		for (Boolean result : testProducer.getRecords())
			assertEquals(true, result);
		assertEquals(13, edgePro.getRecords().size());
	}
}
