/**
 * Week 1 - Day 4 - Singleton Task
 */
package com.ss.firstwk.thurs.demo;

import com.ss.firstwk.thurs.SingletonCar;

/**
 * Singleton Car Demo
 * @author lexne
 *
 */
public class SingleCarDemo {

	/**
	 * Each instance of car should be shared
	 * @param args
	 */
	public static void main(String[] args) {
		SingletonCar momsCar = SingletonCar.getInstance();
		SingletonCar kidsCar = SingletonCar.getInstance();
		
		System.out.println("Mom's gas tank: " + momsCar.getGasTank());
		System.out.println("Teen drives, leaving: " + kidsCar.driveCar(40));
		System.out.println("Mom has to fill it back up to: " + momsCar.fillTank(40));
		System.out.println("Teen now has " + kidsCar.getGasTank() + " gallons of gas");
	}

}
