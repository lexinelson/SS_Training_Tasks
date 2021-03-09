/**
 * Week 1 - Day 1 - Pattern Task
 */
package com.ss.tasks.pattern;

/**
 * Star Pattern Class
 * @author Lexi Nelson
 *
 */
public class Pattern {
	/**
	 * Tracker and key generator
	 */
	private static int instanceCount = 0;
	private final int id;
	
	/**
	 * instance variables
	 */
	protected int height;
	protected boolean isUpright;
	
	/**
	 * Constructor - default orientation is upright
	 * @param height
	 */
	public Pattern(int height) {
		this(height, true);
	}
	
	/**
	 * Constructor
	 * @param height
	 * @param isUpright
	 */
	public Pattern(int height, boolean isUpright) {
		id = ++instanceCount;
		this.height = height;
		this.isUpright = isUpright;
	}
	
	/**
	 * Prints pattern with header to console
	 */
	public void printPattern() {
		printHeader();
		if (isUpright) {
			for (int i = 1; i <= height; i++) {
				System.out.println(makeLine(i, "*"));
			}
			System.out.println(makeBase());
		}
		else {
			System.out.println(makeBase());
			for (int i = height; i > 0; i--) {
				System.out.println(makeLine(i, "*"));
			}
		}
	}
	
	/**
	 * Generates line of dashes based on id (+8)
	 * @return
	 */
	protected String makeBase() {
		int length = 8 + id;
		return makeLine(length, "-");
	}
	
	/** 
	 * Generates string of symbols
	 * @param length
	 * @param symbol
	 * @return
	 */
	protected String makeLine(int length, String symbol) {
		String output = "";
		for (int i = 0; i < length; i++) {
			output += symbol;
		}
		return output;
	}
	
	/**
	 * Prints the id to console
	 */
	protected void printHeader() {
		System.out.println(id + ")");
	}
}
