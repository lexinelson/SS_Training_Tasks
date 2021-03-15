/**
 * 
 */
package com.ss.firstwk.fri.proj;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author lexne
 *
 */
public class ArrayFunctionsTest {

	ArrayFunctions base = new ArrayFunctions();
	
	@Test
	public void rightDigitTest() {
		
		assertArrayEquals(new Integer[] {1, 2, 3}, 
				base.rightDigit(new Integer[] {1, 22, 93}));
		assertArrayEquals(new Integer[] {6, 8, 6, 8, 1},
				base.rightDigit(new Integer[] {16, 8, 886, 8, 1}));
		assertArrayEquals(new Integer[] {0, 0},
				base.rightDigit(new Integer[] {10, 0}));
	}
	
	@Test
	public void rightDigitEdgeTest() {
		assertArrayEquals(null, base.rightDigit(null));
		assertArrayEquals(new Integer[] {3, 0}, 
				base.rightDigit(new Integer[] {null, 103, null, 10}));
		assertArrayEquals(new Integer[] {}, base.rightDigit(new Integer[10]));
	}

	@Test
	public void doublingTest() {
		assertArrayEquals(new Integer[] {2, 4, 6}, 
				base.doubling(new Integer[] {1, 2, 3}));
		assertArrayEquals(new Integer[] {12, 16, 12, 16, -2},
				base.doubling(new Integer[] {6, 8, 6, 8, -1}));
		assertArrayEquals(new Integer[] {}, 
				base.doubling(new Integer[] {}));
	}
	
	@Test
	public void doublingEdgeTest() {
		assertArrayEquals(null, base.doubling(null));
		assertArrayEquals(new Integer[] {}, base.doubling(new Integer[10]));
		assertArrayEquals(new Integer[] {4, 10},
				base.doubling(new Integer[] {null, 2, null, null, 5}));
	}

	@Test
	public void noXTest() {
		assertArrayEquals(new String[] {"a", "bb", "c"},
				base.noX(new String[] {"ax", "bb", "cx"}));
		assertArrayEquals(new String[] {"a", "bb", "c"},
				base.noX(new String[] {"xxax", "xbxbx", "xxcx"}));
		assertArrayEquals(new String[] {""},
				base.noX(new String[] {"x"}));
	}
	
	@Test
	public void noXEdgeTest() {
		assertArrayEquals(null, base.noX(null));
		assertArrayEquals(new String[] {"ebra"},
				base.noX(new String[] {null, "xebra", null}));
		assertArrayEquals(new String[] {}, base.noX(new String[10]));
	}

	@Test
	public void groupSumClumpTest() {
		assertEquals(true, 
				base.groupSumClump(new Integer[] {2, 4, 8}, 10));
		assertEquals(true,
				base.groupSumClump(new Integer[] {1, 2, 4, 8, 1}, 14));
		assertEquals(false,
				base.groupSumClump(new Integer[] {2, 4, 4, 8}, 14));
	}
	
	@Test
	public void groupSumClumpEdgeTest() {
		assertEquals(false, base.groupSumClump(new Integer[] {1, 1, 1, 1, 1}, null));
		assertEquals(true, base.groupSumClump(new Integer[] {null, 2, 3, 2, null, 4}, 7));
		assertEquals(false, base.groupSumClump(null, null));
		assertEquals(false, base.groupSumClump(null, 10));
	}
}
