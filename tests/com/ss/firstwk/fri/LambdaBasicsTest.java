package com.ss.firstwk.fri;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LambdaBasicsTest {
	private final PrintStream output = System.out;
	private final ByteArrayOutputStream mockConsole = new ByteArrayOutputStream();
	
	private final BasicLambdas test = new BasicLambdas();
	private final String[] base = {"Hello", "World", "Goodbye", "Worms", "Kale"};

	@Before
	public void boxConsole() throws UnsupportedEncodingException {
		System.setOut(new PrintStream(mockConsole));
	}
	
	@After
	public void unbox() {
		System.setOut(output);
	}
	
	@Test
	public void mainTest() {
		final String result = "Sorted by length in ascending order:" + System.getProperty("line.separator") +
				"Kale, Hello, World, Worms, Goodbye, " + System.getProperty("line.separator") +
				"\nSorted by length in descending order:" + System.getProperty("line.separator") +
				"Goodbye, Hello, World, Worms, Kale, " + System.getProperty("line.separator") +
				"\nSorted alphabetically by first letter:" + System.getProperty("line.separator") + 
				"Goodbye, Hello, Kale, World, Worms, " + System.getProperty("line.separator") +
				"\nArranged by having the letter 'e':" + System.getProperty("line.separator") +
				"Hello, Goodbye, Kale, World, Worms, " + System.getProperty("line.separator") +
				"\nSame arrangement but with static method (changes referenced object):" +
				System.getProperty("line.separator") + "Hello, Goodbye, Kale, World, Worms,";
		
		BasicLambdas.main(base);
		assertEquals(result, mockConsole.toString().trim());
	}
	
	@Test
	public void mainEdgeTest() {
		BasicLambdas.main(null);
		assertEquals("NO ARRAY WAS PASSED", mockConsole.toString().trim());
		BasicLambdas.main(new String[10]);
		assertEquals("NO ARRAY WAS PASSED", mockConsole.toString().trim());
	}
	
	@Test
	public void arrangeTest() {
		assertArrayEquals(new String[]{"World", "Worms", "Kale", "Hello", "Goodbye"}, 
				test.arrange(base, (x, y) -> y.charAt(0) - x.charAt(0)));
		
		assertArrayEquals(new String[] {"Hello", "World", "Goodbye", "Worms", "Kale"}, 
				test.arrange(base, (x, y) -> (x + y).length()));
	}
	
	@Test
	public void arrangeEdgeTest() {
		assertArrayEquals(null, test.arrange(new String[10], (x, y) -> Integer.parseInt(x)/Integer.parseInt(y)));
		assertArrayEquals(null, test.arrange(null, (x, y) -> x.length() - y.length()));
		assertEquals("NO ARRAY WAS PASSED", mockConsole.toString().trim());
	}
	
	@Test
	public void iterateOverTest() {
		test.iterateOver(base, (x) -> System.out.print(x));
		assertEquals("HelloWorldGoodbyeWormsKale", mockConsole.toString().trim());
	}
	
	@Test
	public void iterateOverEdgeTest() {
		test.iterateOver(new String[10], (x) -> System.out.print(x));
		test.iterateOver(null, (x) -> BasicLambdas.main(new String[0]));
		assertEquals("NO ARRAY WAS PASSED", mockConsole.toString().trim());
	}

	@Test
	public void printStringArrayTest() {
		test.printStringArray(base);
		assertEquals("Hello, World, Goodbye, Worms, Kale,", mockConsole.toString().trim());
	}
	
	@Test
	public void printStringArrayEdgeTest() {
		final String result = "3, forty, bye, " + System.getProperty("line.separator") + "NO ARRAY WAS PASSED";
		test.printStringArray(new String[10]);
		test.printStringArray(new String[]{null, "3", "forty", null, null, "bye"});
		test.printStringArray(null);
		assertEquals(result, mockConsole.toString().trim());
	}
}
