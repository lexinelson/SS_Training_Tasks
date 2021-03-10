/**
 * Week 1 - Day 2 - Shapes Task
 */
package com.ss.firstwk.tues.shape;

/**
 * Interface for Shape classes
 * @author Lexi Nelson
 *
 */
public interface Shape {
	
	/**
	 * @return shape area
	 */
	public Integer calculateArea();
	
	/**
	 * prints shape (class) name and area to console
	 */
	default void display() {
		System.out.println(getClass().getSimpleName() + " - Area: " + calculateArea());
	}
}
