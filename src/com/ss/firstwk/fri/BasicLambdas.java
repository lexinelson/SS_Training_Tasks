/**
 * 
 */
package com.ss.firstwk.fri;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author lexne
 *
 */
public class BasicLambdas {
	
	private String[] myArray = new String[]{"Lime", "Evenings", "Morning", "Apples"};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicLambdas basic = new BasicLambdas();
		
		System.out.println("Sorted by length in ascending order:");
		basic.printStringArray(
				basic.arrange(basic.myArray, (x, y) -> x.length() - y.length()));
		
		System.out.println("\nSorted by length in descending order:");
		basic.printStringArray(
				basic.arrange(basic.myArray, (x, y) -> y.length() - x.length()));
		
		System.out.println("\nSorted alphabetically by first letter:");
		basic.printStringArray(
				basic.arrange(basic.myArray, (x, y) -> x.charAt(0) - y.charAt(0)));
		
		System.out.println("\nArranged by having the letter 'e':");
		basic.printStringArray(
				basic.arrange(basic.myArray, (x, y) -> {
					 int xComp = x.contains("e") ? 1 : 2;
					 int yComp = y.contains("e") ? 1 : 2;
					return xComp - yComp;
				}));
		
		System.out.println("\nSame arrangement but with static method (changes referenced object):");
		Arrays.sort(basic.myArray, (s1, s2) -> MyUtils.orderByContents(s1, s2, "e"));
		basic.printStringArray(basic.myArray);
	}
	
	public String[] arrange(String[] original, Comparator<String> lamb) {
		try {
			return Arrays.stream(original).sorted(lamb).toArray(String[]::new);
		} catch (NullPointerException e){
			System.out.println("NO ARRAY WAS PASSED");
			e.printStackTrace();
		}
		return null;
	}

	public void iterateOver(String[] arr, Consumer<Object> lamb) {
		try {
			Arrays.stream(arr).forEach(lamb);
		} catch (NullPointerException e){
			System.out.println("NO ARRAY WAS PASSED");
			e.printStackTrace();
		}
	}
	
	public void printStringArray(String[] s) {
		try {
			iterateOver(s, (x) -> System.out.print(x + ", "));
		} catch (NullPointerException e){
			System.out.println("NO ARRAY WAS PASSED");
			e.printStackTrace();
		}
		System.out.println();
	}
}
