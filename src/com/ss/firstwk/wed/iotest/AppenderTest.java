/**
 * 
 */
package com.ss.firstwk.wed.iotest;

import java.io.IOException;

import com.ss.firstwk.wed.iomodel.FileAppender;

/**
 * @author lexne
 *
 */
public class AppenderTest {

	/**
	 * No arg - appends from default file to default file
	 * first arg (option) - file to append to (uses console)
	 * Two or more arg (option) - appends file(s) to first arg file
	 * @param args
	 */
	public static void main(String[] args) {
		final String defaultInFile = "resources\\in\\test.txt";
		final String defaultOutFile = "resources\\out\\defaultTest.txt";
		FileAppender appender;
		
		switch (args.length) {
			case 0:
				try {
					appender = new FileAppender(defaultOutFile);
					appender.appendFromFile(defaultInFile);
				} catch (IOException e) {
					System.out.println("Something went wrong. The default directories may have been moved or deleted.");
				}
				break;
			case 1:
				try {
					appender = new FileAppender(args[0]);
					appender.appendFromConsole();
				} catch (IOException e) {
					System.out.println("The file you're trying to append doesn't appear to exist. Please double check for typos.");
				}
				break;
			default:
				try {
					appender = new FileAppender(args[0]);
					for (int i = 1; i < args.length; i++)
						appender.appendFromFile(args[i]);
				} catch (IOException e) {
					System.out.println("One of the files you entered does not seem to exist. Try one at a time to avoid errors.");
				}
		}

	}
}
