/**
 * Week 1 - Day 1 - Number Guesser Task
 */
package com.ss.week1.day1.guess;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Runs Random Guesser with range [1, 100], cap of 5 guesses
 * @author Lexi Nelson
 *
 */
public class GuessGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int guessCap = 5;
		final int rangeMin = 1, rangeMax = 100;
		
		Scanner scan = new Scanner(System.in);
		Guesser num = new Guesser(rangeMin, rangeMax);
		
		int guess;
		do {
			num.prompt();
			try {
				guess = scan.nextInt();
			} catch (InputMismatchException e) {
				scan = new Scanner(System.in);
				guess = rangeMin - 1;
			}
			num.checkGuess(guess);
		} while (num.getGuessCount() < guessCap && !num.isGuessedRight());
		
		
		if(!num.isGuessedRight()) {
			System.out.printf("Sorry, you used all %d guesses. The number was %d.%n",
					guessCap, num.getTarget());
		}
	}

}
