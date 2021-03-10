/**
 * Week 1 - Day 1 - Pattern Task
 */
package com.ss.tasks.pattern;

/**
 * Print Pattern and CenterPattern in Console
 * @author Lexi Nelson
 *
 */
public class RunPattern {

	/** Main Method - array of patterns then print
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern[] pat = new Pattern[3];
		pat[0] = new Pattern(4, 6);
		pat[1] = new CenterPattern(4);
		pat[2] = new Pattern(4, false);
		
		for (Pattern pattern : pat) {
			pattern.printPattern();
		}
	}

}
