/**
 * Week 1 - Day 3 - View Directory task
 */
package com.ss.firstwk.wed.iomodel;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold directory path and contents
 * @author Lexi Nelson
 *
 */
public class DirectoryViewer {

	private Path path;
	private List<Path> contents = new ArrayList<>();
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return path.toString();
	}

	/**
	 * Checks path and fills contents if good
	 * @param the path to set
	 * @throws IOException 
	 */
	public void setPath(String path) throws IOException {
		fillContents(path);
		this.path = Paths.get(path);
	}

	/**
	 * Constructor - fills contents or throws exceptions
	 * @param path
	 * @throws IOException
	 */
	public DirectoryViewer(String path) throws IOException {
		fillContents(path);
		this.path = Paths.get(path);
	}
	
	/**
	 * Populates contents list if path is valid
	 * @throws IOException
	 */
	private void fillContents(String path) throws IOException {
		try (DirectoryStream<Path> dir = Files.newDirectoryStream(Paths.get(path))) {	
			contents.clear();
			for (Path p : dir) {
				contents.add(p);
				if (p.toFile().isDirectory())
					addDir(p);
			}
		}
	}
	
	/**
	 * Nested adding for sub directories
	 * @param path
	 * @throws IOException
	 */
	private void addDir(Path path) throws IOException {
		try (DirectoryStream<Path> dir = Files.newDirectoryStream(path)) {
			for (Path p : dir)
				contents.add(p);
		}
	}
	
	/**
	 * Display contents to console
	 */
	public void display() {
		System.out.printf("Directory contents for %s:%n%n", path.toString());
		for (Path item : contents)
			System.out.println(item.toString().substring(path.toString().length() + 1));
	}
}
