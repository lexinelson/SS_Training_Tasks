package com.ss.firstwk.wed.iotest;

import java.io.IOException;
import com.ss.firstwk.wed.iomodel.FileCharCounter;

public class FileCounterTest {
	
	public static void main(String[] args) {
		FileCounterTest test = new FileCounterTest();
		final String defaultFile = "resources\\in\\lorem.txt";
		
		switch (args.length) {
		case 0:
			test.searchFile(defaultFile, 'a');
			break;
		case 1:
			test.searchFile(defaultFile, args[0]);
		default:
			for (int i = 1; i < args.length; i++) {
				test.searchFile(args[i], args[0]);
			}
		}
		
	}
	
	public void searchFile(String fileName, char c) {
		try {
			FileCharCounter counter = new FileCharCounter(fileName, c);
			System.out.printf("%s: The character %s appears %d times.%n", fileName, c, counter.getCount());
		} catch (IOException e) {
			System.out.println("There was a problem accesing " + fileName);
		}
	}
	
	public void searchFile(String fileName, String multi) {
		for (char c : multi.toCharArray())
			this.searchFile(fileName, c);
	}
}
