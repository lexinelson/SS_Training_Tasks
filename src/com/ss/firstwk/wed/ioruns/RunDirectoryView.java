/**
 * Week 1 - Day 3 - View Directory task application
 */
package com.ss.firstwk.wed.ioruns;

import java.io.IOException;
import com.ss.firstwk.wed.iomodel.DirectoryViewer;

/**
 * Application Test for DirectoryViewer
 * @author Lexi Nelson
 *
 */
public class RunDirectoryView {

	/**
	 * searches for provided directory or default resources
	 * @param args
	 */
	public static void main(String[] args) {
		RunDirectoryView viewer = new RunDirectoryView();
		final String defaultDir = "resources";
		DirectoryViewer dir = null;
		
		try {
			viewer.attemptDir(dir, args[0]);
		}
		catch (IndexOutOfBoundsException e) {
			viewer.attemptDir(dir, defaultDir);
		}
	}
	
	/**
	 * displays directory contents - catches IO ex
	 * @param dir
	 * @param path
	 */
	public void attemptDir(DirectoryViewer dir, String path) {
		try {
			dir = new DirectoryViewer(path);
			dir.display();
		}
		catch (IOException e) {
			System.out.println("Cannot access this directory. It may not exist.");
			System.out.println("Please exit and try again.");
		}
	}
}
