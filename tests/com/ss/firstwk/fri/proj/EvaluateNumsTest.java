/**
 * 
 */
package com.ss.firstwk.fri.proj;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

/**
 * @author lexne
 *
 */
public class EvaluateNumsTest {

	private final EvaluateNums base = new EvaluateNums();
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private final String line = System.getProperty("line.separator");
	
	@Test
	public void evaluateTest() {
		final String input = "5"+line+"1 4"+line+"2 5"+line+"3 898"+line+"1 3"+line+"2 12";
		final String expected = "EVEN"+line+"PRIME"+line+"PALINDROME"+line+"ODD"+line+"COMPOSITE";
		
		final InputStream in = new ByteArrayInputStream(input.getBytes());
		
		base.evaluate(in, output);
		assertEquals(expected, output.toString().trim());
	}
	
	@Test
	public void evaluateEdgeTest() {
		final String input = "4 1"+line+line+"1 4"+line+"2 5 7"+line+"hello"+line+"3"+line+"1 3 14"+line+"2 12"+line+"9 9";
		final String expected = "EVEN"+line+"PRIME"+line+"ODD"+line+"COMPOSITE";
		
		final InputStream in = new ByteArrayInputStream(input.getBytes());
		
		base.evaluate(in, output);
		assertEquals(expected, output.toString().trim());
	}
	
	@Test
	public void readLineTest() {
		assertArrayEquals(new Integer[] {1, 2, 3}, base.readLine("1 2 3"));
	}
	
	@Test
	public void readLineEdgeTest() {
		assertArrayEquals(new Integer[] {1}, base.readLine("hello 1 Goodbye"));
		try {
			base.readLine("hello there");
		} catch (NumberFormatException e) {
			assertEquals(true, true);
		}
		assertArrayEquals(null, base.readLine(null));
	}
	
	@Test
	public void isOddTest() {
		final Integer[] test = {3, 5, 6};
		final String expected = "ODD"+line+"ODD"+line+"EVEN";
		
		Arrays.stream(test).forEach(base.isOdd(output));
		assertEquals(expected, output.toString().trim());
	}
	
	@Test
	public void isOddEdgeTest() {
		final Integer[] test = new Integer[10];
		final Integer[] test2 = {3, null, 6};
		final String expected = "ODD"+line+"EVEN";
		
		Arrays.stream(test).forEach(base.isOdd(output));
		Arrays.stream(test2).forEach(base.isOdd(output));
		assertEquals(expected, output.toString().trim());
	}
	
	@Test
	public void isPrimeTest() {
		final Integer[] test = {3, 5, 6};
		final String expected = "PRIME"+line+"PRIME"+line+"COMPOSITE";
		
		Arrays.stream(test).forEach(base.isPrime(output));
		assertEquals(expected, output.toString().trim());
	}
	
	@Test
	public void isPrimeEdgeTest() {
		final Integer[] test = new Integer[10];
		final Integer[] test2 = {3, null, 6};
		final String expected = "PRIME"+line+"COMPOSITE";
		
		Arrays.stream(test).forEach(base.isPrime(output));
		Arrays.stream(test2).forEach(base.isPrime(output));
		assertEquals(expected, output.toString().trim());
	}
	
	@Test
	public void isPalindromeTest() {
		final Integer[] test = {383, 626, 411};
		final String expected = "PALINDROME"+line+"PALINDROME"+line+"NOT PALINDROME";
		
		Arrays.stream(test).forEach(base.isPalindrome(output));
		assertEquals(expected, output.toString().trim());
	}
	
	@Test
	public void isPalindromeEdgeTest() {
		final Integer[] test = new Integer[10];
		final Integer[] test2 = {3, null, 626};
		final String expected = "PALINDROME"+line+"PALINDROME";
		
		Arrays.stream(test).forEach(base.isPalindrome(output));
		Arrays.stream(test2).forEach(base.isPalindrome(output));
		assertEquals(expected, output.toString().trim());
	}
}
