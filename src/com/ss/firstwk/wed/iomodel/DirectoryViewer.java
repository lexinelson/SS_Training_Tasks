/**
 * 
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
 * @author lexne
 *
 */
public class DirectoryViewer {

	private Path path;
	private List<Path> contents = new ArrayList<>();
	
	/**
	 * @return the path
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(Path path) {
		this.path = path;
	}

	/**
	 * @param path
	 * @throws IOException
	 */
	public DirectoryViewer(String path) throws IOException {
		this.path = Paths.get(path);
		fillContents();
	}
	
	/**
	 * @throws IOException
	 */
	private void fillContents() throws IOException {
		try (DirectoryStream<Path> dir = Files.newDirectoryStream(path)) {	
			contents.clear();
			for (Path p : dir) {
				contents.add(p);
				if (p.toFile().isDirectory())
					addDir(p);
			}
		}
	}
	
	private void addDir(Path path) throws IOException {
		try (DirectoryStream<Path> dir = Files.newDirectoryStream(path)) {
			for (Path p : dir)
				contents.add(p);
		}
	}
	
	/**
	 * 
	 */
	public void display() {
		System.out.printf("Directory contents for %s:%n%n", path.toString());
		for (Path item : contents)
			System.out.println(item.toString().substring(path.toString().length() + 1));
	}
}
