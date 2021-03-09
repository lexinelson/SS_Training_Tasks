package com.ss.tasks.pattern;

/**
 * Star Pattern with Center Alignment Class
 * @author Lexi Nelson
 *
 */
public class CenterPattern extends Pattern {

	/**
	 * Constructor - calls parent
	 * @param size
	 */
	public CenterPattern(int size) {
		super(size);
	}
	
	/**
	 * Constructor - calls parent
	 * @param size
	 * @param isUpright
	 */
	public CenterPattern(int size, boolean isUpright) {
		super(size, isUpright);
	}
	
	/**
	 * prints centered pattern to console
	 */
	@Override
	public void printPattern() {
		printHeader();
		int width = isUpright ? getMidpoint() : getMidpoint() + (height - 1);
		int count = isUpright ? 1 : 2 * height - 1;
		
		if (!isUpright)
			System.out.println(makeBase());
		for (int i = 0; i < height; i++) {
			String format = "%" + width + "s%n";
			System.out.printf(format, makeLine(count, "*"));
			if (isUpright) {
				++width;
				count += 2;
			}
			else {
				--width;
				count -= 2;
			}
		}
		if (isUpright)
			System.out.println(makeBase());
	}
	
	
	
	/**
	 * returns the midpoint of the dashed base
	 * @return
	 */
	private int getMidpoint() {
		int width = makeBase().length();
		return (width % 2 == 0) ? width/2 : width/2 + 1;
	}
}
