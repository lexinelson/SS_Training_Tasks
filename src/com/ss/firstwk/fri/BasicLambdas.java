/**
 * Week 1 - Day 5 - Lambdas Task
 */
package com.ss.firstwk.fri;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Basic Lambdas exercises
 * @author Lexi Nelson
 *
 */
public class BasicLambdas {

	/**
	 * Main - reads an array, runs the ops on it
	 * @param args
	 */
	public static void main(String[] args) {
		BasicLambdas basic = new BasicLambdas();
		boolean arrayExists = true;
		
		try {
			args = Arrays.stream(args).filter(x -> x != null).toArray(String[]::new);
		} catch (NullPointerException e) {
			if (args == null) {
				System.out.println("NO ARRAY WAS PASSED");
				arrayExists = false;
			}
		}

		if (arrayExists && args.length > 0) {
			System.out.println("Sorted by length in ascending order:");
			basic.printStringArray(
					basic.arrange(args, (x, y) -> x.length() - y.length()));

			System.out.println("\nSorted by length in descending order:");
			basic.printStringArray(
					basic.arrange(args, (x, y) -> y.length() - x.length()));

			System.out.println("\nSorted alphabetically by first letter:");
			basic.printStringArray(
					basic.arrange(args, (x, y) -> x.charAt(0) - y.charAt(0)));

			System.out.println("\nArranged by having the letter 'e':");
			basic.printStringArray(
					basic.arrange(args, (x, y) -> {
						int xComp = x.contains("e") ? 1 : 2;
						int yComp = y.contains("e") ? 1 : 2;
						return xComp - yComp;
					}));

			System.out.println("\nSame arrangement but with static method (changes referenced object):");
			Arrays.sort(args, (s1, s2) -> MyUtils.orderByContents(s1, s2, "e"));
			basic.printStringArray(args);
		}
	}
	
	/**
	 * Sorts an array using the given comparator lambda
	 * @param original
	 * @param lamb
	 * @return
	 */
	public String[] arrange(String[] original, Comparator<String> lamb) {
		try {
			return Arrays.stream(original).filter((x) -> x != null).sorted(lamb).toArray(String[]::new);
		} catch (NullPointerException e){
			System.out.println("NO ARRAY WAS PASSED");
		}
		return null;
	}

	/**
	 * Iterates over array with given consumer lambda
	 * @param arr
	 * @param lamb
	 */
	public void iterateOver(String[] arr, Consumer<Object> lamb) {
		try {
			Arrays.stream(arr).filter((x) -> x != null).forEach(lamb);
		} catch (NullPointerException e){
			System.out.println("NO ARRAY WAS PASSED");
		}
	}
	
	/**
	 * Uses iterate (above) to print every item in given array
	 * @param s
	 */
	public void printStringArray(String[] s) {
		try {
			iterateOver(s, (x) -> System.out.print(x + ", "));
		} catch (NullPointerException e){
			System.out.println("NO ARRAY WAS PASSED");
		}
		System.out.println();
	}
}
