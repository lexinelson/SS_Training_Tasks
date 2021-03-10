/**
 * Week 1 - Day 2 - Array task
 */
package com.ss.firstwk.tues.array;

/**
 * Class for 2d Integer Array
 * @author Lexi Nelson
 *
 */
public class IntArray2D {
	
	private Integer[][] arr;

	/**
	 * Constructor
	 * @param row
	 * @param col
	 */
	public IntArray2D(Integer row, Integer col) {
		arr = new Integer[row][col];
	}
	
	/**
	 * Add value to a slot in array
	 * @param val
	 * @param row
	 * @param col
	 */
	public void add(Integer val, Integer row, Integer col) {
		arr[row][col] = val;
	}
	
	/**
	 * fills array with random positive numbers under 100
	 */
	public void fillRandom() {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				add((int) (1 + Math.random() * 99), r, c);
			}
		}
	}
	
	/**
	 * Display table representation of array to console
	 */
	public void display() {
		for (Integer[] array : arr) {
			for(Integer val : array) {
				System.out.printf("%4d", val);
			}
			System.out.println();
		}
	}
	
	/**
	 * @return maximum value in 2D array
	 */
	public Integer max() {
		Integer max = arr[0][0];
		for (Integer r = 0; r < arr.length; r++) {
			for (Integer c = 0; c < arr[r].length; c++) {
				max = (arr[r][c] > max) ? arr[r][c] : max;
			}
		}
		return max;
	}
	
	/**
	 * @return minimum value in 2D array
	 */
	public Integer min() {
		Integer min = arr[0][0];
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				min = (arr[r][c] < min) ? arr[r][c] : min;
			}
		}
		return min;
	}
}
