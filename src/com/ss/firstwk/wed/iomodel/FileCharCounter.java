/**
 * Week 1 - Day 3 - Counter Char in File task
 */
package com.ss.firstwk.wed.iomodel;

import java.io.FileReader;
import java.io.IOException;

/**
 * Character Counter from File class
 * @author Lexi Nelson
 *
 */
public class FileCharCounter {
	private Integer count = 0;
	private StringBuffer path = new StringBuffer();
	private Character target;
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return path.toString();
	}

	/**
	 * sets path - refreshes count if valid
	 * @param the path to set
	 */
	public void setPath(String path) throws IOException {
		count(path);
		this.path.delete(0, this.path.length());
		this.path.append(path);
	}

	/**
	 * @return the target
	 */
	public Character getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Character target) {
		this.target = target;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * counts or throws exception at initialization
	 * @param path
	 * @param target
	 * @throws IOException
	 */
	public FileCharCounter(String path, char target) throws IOException {
		this.target = target;
		count = count(path);
		this.path.append(path);
	}
	
	/**
	 * Checks file for target character
	 * @param path
	 * @return instances of target in file
	 * @throws IOException
	 */
	private int count(String path) throws IOException {
		try (FileReader in = new FileReader(path)) {
			int c;
			while ((c = in.read()) != -1) {
				if (target.equals((char) c))
					++count;
			}
			return count;
		}
	}
}
