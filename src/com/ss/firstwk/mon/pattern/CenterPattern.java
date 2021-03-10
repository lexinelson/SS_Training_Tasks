/**
 * Week 1 - Day 1 - Pattern Task
 */
package com.ss.firstwk.mon.pattern;

/**
 * Star Pattern with Center Alignment Class
 * @author Lexi Nelson
 *
 */
public class CenterPattern extends Pattern {

	/**
	 * Constructor - calls parent default baseWidth and isUpright
	 * @param height
	 */
	public CenterPattern(int height) {
		super(height);
	}
	
	/**
	 * Constructor - calls parent default for isUpright
	 * @param height
	 * @param baseWidth
	 */
	public CenterPattern(int height, int baseWidth) {
		super(height, baseWidth);
	}
	
	/**
	 * Constructor - calls parent default for baseWidth
	 * @param height
	 * @param isUpright
	 */
	public CenterPattern(int height, boolean isUpright) {
		super(height, isUpright);
	}
	
	/**
	 * Full Constructor - calls parent
	 * @param height
	 * @param baseWidth
	 * @param isUpright
	 */
	public CenterPattern(int height, int baseWidth, boolean isUpright) {
		super(height, baseWidth, isUpright);
	}
	
	/**
	 * prints centered pattern to console
	 */
	@Override
	public void printPattern() {
		printHeader();
		int width;
		
		if (isUpright) {
			width = getMidpoint();
			for (int i = 1; i <= height; i++) {
				System.out.printf(formatStr(width), makeLine(i, " *"));
				width++;
			}
			System.out.println(makeBase());
		}
		else {
			System.out.println(makeBase());
			width = getMidpoint() + height;
			for (int i = height; i > 0; i--) {
				System.out.printf(formatStr(width),  makeLine(i, " *"));
				width--;
			}
		}
	}
	
	
	
	/**
	 * returns the midpoint of the dashed base
	 * @return peak of pyramid
	 */
	private int getMidpoint() {
		return (height % 2 == 0) ? height + 1 : height;
	}
	
	/**
	 * Returns a format string of given width
	 * @param width
	 * @return format notation
	 */
	private String formatStr(int width) {
		return "%" + width + "s%n";
	}
}
