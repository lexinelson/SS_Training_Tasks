/**
 * Week 1 - Day 1 - Number Guesser Task
 */
package com.ss.tasks.guess;

/**
 * Random Number Guesser Class
 * @author Lexi Nelson
 *
 */
public class Guesser {
	/**
	 * constant variables holding instance data
	 */
	private final int target;
	private final int max, min;
	
	/**
	 * instance variable measuring progress
	 */
	private int guessCount = 0;
	private boolean guessedRight = false;
	
	/**
	 * Generate target num from given range, saves range.
	 * @param max
	 * @param min
	 */
	public Guesser(int min, int max) {
		this.max = max;
		this.min = min;
		target = min + (int) (Math.random() * max);
	}

	/**
	 * @return the guessCount
	 */
	public int getGuessCount() {
		return guessCount;
	}
	
	/**
	 * @return the target
	 */
	public int getTarget() {
		return target;
	}
	
	/**
	 * return boolean whether there's been successful guess
	 * @return the guessedRight
	 */
	public boolean isGuessedRight() {
		return guessedRight;
	}

	/**
	 * Check guess against target, count as guess, print result
	 * @param guess
	 */
	public void checkGuess(int guess) {
		if (guess < min || guess > max) {
			errorMessage();
		} 
		else {
			if (guess >= target-10 && guess <= target+10) 
				guessedRight = true;
			++guessCount;
			printResult();
		}
	}
	
	/**
	 * prompt for user to provide number in valid range
	 */
	public void prompt() {
		System.out.printf("Please enter a number between %d and %d: ", min, max);
	}
	
	/**
	 * prints message to console that guess broke rules - didn't count
	 */
	public void errorMessage() {
		System.out.println("Not a valid guess, please try again");
	}
	
	/**
	 * print console whether guess was close enough or incorrect
	 */
	private void printResult() {
		if (guessedRight) {
			System.out.println("Congratulations! You're guess was close enough to " + target);
		}
		else {
			System.out.println("Incorrect. Please guess again...\n");
		}
	}
}
