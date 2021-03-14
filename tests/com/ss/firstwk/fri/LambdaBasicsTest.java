package com.ss.firstwk.fri;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LambdaBasicsTest {
	private final PrintStream output = System.out;
	private final ByteArrayOutputStream mockConsole = new ByteArrayOutputStream();
	
	private final BasicLambdas test = new BasicLambdas();
	private final String[] base = {"Hello", "World", "Goodbye"};

	@Before
	public void boxConsole() {
		System.setOut(new PrintStream(mockConsole));
	}
	
	@After
	public void unbox() {
		System.setOut(output);
	}
	
	@Test
	public void arrangeTest() {
		assertArrayEquals(new String[]{"World", "Hello", "Goodbye"}, 
				test.arrange(base, (x, y) -> y.charAt(0) - x.charAt(0)));
		
		assertArrayEquals(new String[] {"Hello", "World", "Goodbye"}, 
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
		assertEquals("HelloWorldGoodbye", mockConsole.toString().trim());
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
		assertEquals("Hello, World, Goodbye", mockConsole.toString().trim());
	}
	
	@Test
	public void printStringArrayEdgeTest() {
		test.printStringArray(new String[10]);
		test.printStringArray(null);
		assertEquals("NO ARRAY WAS PASSED", mockConsole.toString().trim());
	}
}
