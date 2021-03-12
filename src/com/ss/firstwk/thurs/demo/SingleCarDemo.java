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
//		
//		System.out.println("Mom's gas tank: " + momsCar.getGasTank());
//		System.out.println("Teen drives, leaving: " + kidsCar.driveCar(40));
//		System.out.println("Mom has to fill it back up to: " + momsCar.fillTank(40));
//		System.out.println("Teen now has " + kidsCar.getGasTank() + " gallons of gas");
		
		
		//demo for lack of thread safety (fix over weekend)
		
		Runnable teenDrives = new Runnable() {
			@Override
			public void run() {
				kidsCar.driveCar(10);
				kidsCar.driveCar(30);
				kidsCar.fillTank(5);
				System.out.println(kidsCar.getGasTank() + " teen");
			}
		};
		Runnable parentDrives = new Runnable() {
			@Override
			public void run() {
				momsCar.driveCar(10);
				momsCar.fillTank(30);
				momsCar.driveCar(5);
				System.out.println(momsCar.getGasTank() + " mom");
			}
		};
		
		new Thread(teenDrives).start();
		new Thread(parentDrives).start();
		System.out.println("Teen: " + kidsCar.getGasTank() + " Parent: " + momsCar.getGasTank());
	}

}
