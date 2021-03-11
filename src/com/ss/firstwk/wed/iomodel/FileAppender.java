/**
 * Week 1 - Day 3 - Append to File task
 */
package com.ss.firstwk.wed.iomodel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * File Appender class
 * @author Lexi Nelson
 *
 */
public class FileAppender {
	private StringBuffer outPath = new StringBuffer();
	
	/**
	 * @return the outPath
	 */
	public String getOutPath() {
		return outPath.toString();
	}

	/**
	 * @param outPath the outPath to set
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void setOutPath(String outPath) throws IOException {
		verifyFile(outPath);
	}

	/**
	 * Constructor - checks for exception & sets path
	 * @param path
	 * @throws IOException
	 */
	public FileAppender(String path) throws IOException {
		verifyFile(path);
	}
	
	/**
	 * checks that file is valid to throw exception at initialization
	 * @param path
	 * @throws IOException
	 */
	private void verifyFile(String path) throws IOException {
		try (FileInputStream out = new FileInputStream(path)) {
			if (outPath .length() > 0)
				outPath.delete(0, outPath.length());
			outPath.append(path);
		}
	}
	
	/**
	 * Appends a string of text to file at outFile path
	 * @param text
	 * @throws IOException
	 */
	public void appendToFile(String text) throws IOException {
		try (FileWriter out = new FileWriter(outPath.toString(), true)) {
			out.append("\n" + text);
		}
	}
	
	/**
	 * Reads a file as a string of text
	 * @param inPath
	 * @return the files text as string
	 * @throws IOException
	 */
	public String getFromFile(String inPath) throws IOException {
		StringBuffer result = new StringBuffer();
		try (FileReader in = new FileReader(inPath)) {
			int c;
			while ((c = in.read()) != -1)
				result.append((char) c);
		}
		return result.toString();
	}
	
	/**
	 * Bridge function - appends text from a file to outPath file
	 * @param inPath
	 * @throws IOException
	 */
	public void appendFromFile(String inPath) throws IOException {
		appendToFile(getFromFile(inPath));
	}
	
	/**
	 * Appends text from console input to outPath file
	 * @throws IOException
	 */
	public void appendFromConsole() throws IOException {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Please enter the line you'd like to append to " + outPath + ":");
			appendToFile(scan.nextLine());
		}
	}
}
