/**
 * 
 */
package com.ss.firstwk.wed.iomodel;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author lexne
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
	 * @param path the path to set
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

	public FileCharCounter(String path, char target) throws IOException {
		this.target = target;
		count = count(path);
		this.path.append(path);
	}
	
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
