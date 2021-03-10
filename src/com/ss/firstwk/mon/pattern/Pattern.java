/**
 * Week 1 - Day 1 - Pattern Task
 */
package com.ss.firstwk.mon.pattern;

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
	private int baseWidth;
	protected int height;
	protected boolean isUpright;
	
	/**
	 * Constructor - default orientation is upright, default baseWidth is 5
	 * @param height
	 */
	public Pattern(int height) {
		this(height, 5, true);
	}
	
	/** Constructor, default upright is true
	 * @param baseWidth
	 * @param height
	 */
	public Pattern(int height, int baseWidth) {
		this(height, baseWidth, true);
	}

	/**Constructor, default baseWidth is 0
	 * @param height
	 * @param isUpright
	 */
	public Pattern(int height, boolean isUpright) {
		this(height, 5, isUpright);
	}

	/**
	 * Full Constructor
	 * @param height
	 * @param baseWidth
	 * @param isUpright
	 */
	public Pattern(int height, int baseWidth, boolean isUpright) {
		id = ++instanceCount;
		this.height = height;
		this.baseWidth = baseWidth;
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
		return makeLine(baseWidth, ".");
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
