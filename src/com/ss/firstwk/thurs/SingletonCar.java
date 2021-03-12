/**
 * 
 */
package com.ss.firstwk.thurs;

/**
 * @author lexne
 *
 */
public class SingletonCar {
	
	volatile private static SingletonCar familyCar = null;
	
	private Integer gasTank;
	
	private SingletonCar() {
		gasTank = 45;
	}
	
	public static SingletonCar getInstance() {
		if (familyCar == null)
			synchronized (SingletonCar.class) {
				if (familyCar == null)
					familyCar = new SingletonCar();
			}
		return familyCar;
	}
	
	public Integer getGasTank() {
		return gasTank;
	}
	
	public Integer driveCar(Integer miles) {
		if (gasTank > miles) 
			gasTank -= miles;
		else
			gasTank = 0;
		return gasTank;
	}
	
	public Integer fillTank(Integer gas) {
		gasTank += gas;
		if (gasTank > 45)
			gasTank = 45;
		return gasTank;
	}
}
