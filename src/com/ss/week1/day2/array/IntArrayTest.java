/**
 * Week 1 - Day 2 - Array task
 */
package com.ss.week1.day2.array;

/**
 * Test to run IntArray2D class
 * @author Lexi Nelson
 *
 */

public class IntArrayTest {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		IntArray2D myArray = new IntArray2D(5, 7);
		myArray.fillRandom();

		myArray.display();
		
		System.out.println();
		System.out.println("Max: " + myArray.max());
		System.out.println("Min: " + myArray.min());
	}
}
