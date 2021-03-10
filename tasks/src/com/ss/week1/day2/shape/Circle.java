/**
 * Week 1 - Day 2 - Shapes task
 */
package com.ss.week1.day2.shape;

/**
 * Circle class
 * @author Lexi Nelson
 *
 */
public class Circle implements Shape {
	
	private Integer radius;
	
	/**
	 * Constructor
	 * @param radius
	 */
	public Circle(Integer radius) {
		this.radius = radius;
	}

	@Override
	public Integer calculateArea() {
		return (int) (Math.PI * radius * radius);
	}
}
