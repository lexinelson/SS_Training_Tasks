/**
 * Week 1 - Day 2 - Shapes task
 */
package com.ss.tasks.shapes;

/**
 * Rectangle class
 * @author Lexi Nelson
 *
 */
public class Rectangle implements Shape {
	private Integer width, height;
	
	/**
	 * Constructor
	 * @param width
	 * @param height
	 */
	public Rectangle(Integer width, Integer height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public Integer calculateArea() {
		return width * height;
	}

	@Override
	public void display() {
		System.out.println("Rectangle - Area: " + calculateArea());
	}

}