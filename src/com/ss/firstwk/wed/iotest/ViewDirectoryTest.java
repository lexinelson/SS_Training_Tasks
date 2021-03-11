/**
 * 
 */
package com.ss.firstwk.wed.iotest;

import java.io.IOException;
import com.ss.firstwk.wed.iomodel.DirectoryViewer;

/**
 * @author lexne
 *
 */
public class ViewDirectoryTest {

	public static void main(String[] args) {
		ViewDirectoryTest viewer = new ViewDirectoryTest();
		final String defaultDir = "resources";
		DirectoryViewer dir = null;
		
		try {
			viewer.attemptDir(dir, args[0]);
		}
		catch (IndexOutOfBoundsException e) {
			viewer.attemptDir(dir, defaultDir);
		}
	}
	
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
