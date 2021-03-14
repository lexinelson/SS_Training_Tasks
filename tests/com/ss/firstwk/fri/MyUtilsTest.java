/**
 * 
 */
package com.ss.firstwk.fri;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author lexne
 *
 */
public class MyUtilsTest {
	private final MyUtils base = new MyUtils();
	
	
	@Test
	public void orderByContentsTest() {
		assertEquals(0, MyUtils.orderByContents("apple", "oranges", "a"));
		assertEquals(1, MyUtils.orderByContents("apples", "oranges", "g"));
		assertEquals(-1, MyUtils.orderByContents("apples", "oranges", "p"));
	}
	
	@Test
	public void orderByContentsEdgeTest() {
		assertEquals(0, MyUtils.orderByContents("apple", "oranges", null));
		assertEquals(-1, MyUtils.orderByContents(null, "oranges", null));
		assertEquals(1, MyUtils.orderByContents(null, "oranges", "p"));
		assertEquals(0, MyUtils.orderByContents(null, null, "*"));
	}
	
	@Test
	public void concatIntArrayTest() {
		final List<Integer> test = Arrays.asList(3, 4, 5);
		assertEquals("o3,e4,o5", base.concatIntList(test));
	}
	
	@Test
	public void concatIntArrayEdgeTest() {
		assertEquals("", base.concatIntList(Arrays.asList()));
		assertEquals("o3,o5", base.concatIntList(Arrays.asList(3, null, 5)));
		assertEquals("", base.concatIntList(null));
	}
	
	@Test
	public void filterByThreeAndATest() {
		final List<String> test = Arrays.asList("ace", "hello", "apes", "are");
		assertArrayEquals(new String[] {"ace", "are"}, base.filterThreeCountAndA(test).toArray());
	}
	
	@Test
	public void filterByThreeAndAEdgeTest() {
		final List<String> mixedEdge = Arrays.asList(null, "ace", "are", null, null);
		final List<String> fullNull = Arrays.asList(new String[10]);
		
		assertArrayEquals(new String[] {"ace", "are"}, base.filterThreeCountAndA(mixedEdge).toArray());
		assertArrayEquals(new String[] {}, base.filterThreeCountAndA(fullNull).toArray());
		assertArrayEquals(null, base.filterThreeCountAndA(null).toArray());
	}
}
