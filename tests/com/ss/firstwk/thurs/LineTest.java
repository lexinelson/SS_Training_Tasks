/**
 * 
 */
package com.ss.firstwk.thurs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

/**
 * @author lexne
 *
 */
public class LineTest {

	private Line test = new Line(1, 1, 50, 50);
	private Line edge = new Line(0, 0, 0, 0);
	
	@Test
	public void getSlopeTest() {
		assertEquals(1.0, test.getSlope(), 0.0001);
		assertNotEquals(test.getSlope(), 1.5, 0.0001);
	}
	
	@Test
	public void getDistanceTest() {
		Line easyLine = new Line(5, 0, 5, 5);
		assertEquals(5.0, easyLine.getDistance(), 0.0001);
		assertNotEquals(easyLine.getDistance(), 4.5, 0.0001);
		assertEquals(69.2964, test.getDistance(), 0.0001);
	}
	
	@Test
	public void ParellelToTest() {
		Line par = new Line(2, 2, 6, 6);
		assertEquals(true, test.parallelTo(par));
		par = new Line(6, 2, 2, 6);
		assertEquals(par.parallelTo(test), false);
	}
	
	@Test (expected = ArithmeticException.class)
	public void getSlopeEdgeTest() {
		edge.getSlope();
	}

	@Test
	public void getDistanceEdgeTest() {
		assertEquals(0.0, edge.getDistance(), 0.0001);
		assertNotEquals(null, edge.getDistance(), 0.0001);
	}
	
	@Test
	public void parellelToEdgeTest() {
		try {
			edge.parallelTo(test);
			assertEquals(true, false);
		} catch (ArithmeticException e) {
			assertEquals(true, true);
		}
	}
}
