/**
 * Week 1 - Day 2 - Shapes Task
 */
package com.ss.week1.day2.shape;

/**
 * Triangle class
 * @author Lexi Nelson
 *
 */
public class Triangle implements Shape {

	private Integer base, height;
	
	/**
	 * Constructor
	 * @param base
	 * @param height
	 */
	public Triangle(Integer base, Integer height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public Integer calculateArea() {
		return (base * height) / 2;
	}
}
