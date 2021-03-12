/**
 * Week 1 - Day 3 - Counter Char in File app
 */
package com.ss.firstwk.wed.ioruns;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.ss.firstwk.wed.iomodel.FileCharCounter;

/**
 * Application Test for FileCharCounter class
 * @author Lexi Nelson
 *
 */

public class RunFileCounter {
	
	/**
	 * counts provided char (or 'a') from provided directories or a default
	 * @param args (0-target(s), 1+.. directories to search)
	 */
	public static void main(String[] args) {
		RunFileCounter test = new RunFileCounter();
		final String[] defaultInFile = {"resources", "in", "lorem.txt"};
		final String defPath = test.constructPath(defaultInFile);
		
		switch (args.length) {
		case 0:
			test.searchFile(defPath, 'a');
			break;
		case 1:
			test.searchFile(defPath, args[0]);
		default:
			for (int i = 1; i < args.length; i++) {
				test.searchFile(args[i], args[0]);
			}
		}
		
	}
	
	/**
	 * Displays char count from file or catches Exception
	 * @param fileName
	 * @param c
	 */
	public void searchFile(String fileName, char c) {
		try {
			FileCharCounter counter = new FileCharCounter(fileName, c);
			System.out.printf("%s: The character %s appears %d times.%n", fileName, c, counter.getCount());
		} catch (IOException e) {
			System.out.println("There was a problem accesing " + fileName);
		}
	}
	
	/**
	 * Search file for multiple chars (pulled from the string)
	 * @param fileName
	 * @param multi
	 */
	public void searchFile(String fileName, String multi) {
		for (char c : multi.toCharArray())
			this.searchFile(fileName, c);
	}
	
	public String constructPath(String[] path) {
		Path output = Paths.get(path[0]);
		for (int i = 1; i < path.length; i++)
			output = output.resolve(path[i]);
		return output.toString();
	}
}
