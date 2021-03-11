/**
 * 
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
 * @author lexne
 *
 */
public class FileReadWrite {
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
		checkFile(outPath);
	}

	public FileReadWrite(String path) throws IOException {
		checkFile(path);
	}
	
	private void checkFile(String path) throws IOException {
		try (FileInputStream out = new FileInputStream(path)) {
			if (outPath .length() > 0)
				outPath.delete(0, outPath.length());
			outPath.append(path);
		}
	}
	
	public void appendToFile(String text) throws IOException {
		try (FileWriter out = new FileWriter(outPath.toString(), true)) {
			out.append("\n" + text);
		}
	}
	
	public String getFromFile(String inPath) throws IOException {
		StringBuffer result = new StringBuffer();
		try (FileReader in = new FileReader(inPath)) {
			int c;
			while ((c = in.read()) != -1)
				result.append((char) c);
		}
		return result.toString();
	}
	
	public void appendFromFile(String inPath) throws IOException {
		appendToFile(getFromFile(inPath));
	}
	
	public void appendFromConsole() throws IOException {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Please enter the line you'd like to append to " + outPath + ":");
			appendToFile(scan.nextLine());
		}
	}
}
