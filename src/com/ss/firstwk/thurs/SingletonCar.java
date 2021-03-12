/**
 * Week 1- Day 4 - Singleton Task
 */
package com.ss.firstwk.thurs;

/**
 * Shared car class for singleton task
 * @author Lexi Nelson
 *
 */
public class SingletonCar {
	
	volatile private static SingletonCar familyCar = null;
	
	private Integer gasTank;
	
	/**
	 * private Constructor sets gas
	 */
	private SingletonCar() {
		gasTank = 45;
	}
	
	/**
	 * @return the single shared car
	 */
	public static SingletonCar getInstance() {
		if (familyCar == null)
			synchronized (SingletonCar.class) {
				if (familyCar == null)
					familyCar = new SingletonCar();
			}
		return familyCar;
	}
	
	/**
	 * @return remaining gas
	 */
	public Integer getGasTank() {
		return gasTank;
	}
	
	/**
	 * Use gas in tank
	 * @param miles
	 * @return gas remaining
	 */
	public Integer driveCar(Integer miles) {
		if (gasTank > miles) 
			gasTank -= miles;
		else
			gasTank = 0;
		return gasTank;
	}
	
	/**
	 * Add to gas tank
	 * @param gas
	 * @return new gas amount
	 */
	public Integer fillTank(Integer gas) {
		gasTank += gas;
		if (gasTank > 45)
			gasTank = 45;
		return gasTank;
	}
}
