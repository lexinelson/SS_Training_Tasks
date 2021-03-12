package com.ss.firstwk.thurs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class SingletonCarTest {

	private SingletonCar momsCar = SingletonCar.getInstance();
	private SingletonCar teensCar = SingletonCar.getInstance();
	private SingletonCar grammasCar = SingletonCar.getInstance();
	
	@Test
	public void checkSingleton() {
		assertEquals(grammasCar, momsCar);
		assertEquals(grammasCar, teensCar);
		assertEquals(momsCar, teensCar);
		assertNotEquals(null, momsCar);
	}
	
	@Test
	public void getGasTankTest() {
		assertEquals(grammasCar.getGasTank(), (Integer) 45);
		assertNotEquals(teensCar.getGasTank(), (Integer) 30);
	}
	
	@Test 
	public void driveCarTest() {
		assertEquals((Integer) 30, teensCar.driveCar(15));
		assertNotEquals(momsCar.driveCar(5), (Integer) 45);
		assertEquals((Integer) 0, grammasCar.driveCar(40));
	}
	
	@Test 
	public void fillTankTest() {
		teensCar.driveCar(20);
		assertEquals(grammasCar.fillTank(10), (Integer) 35);
		assertNotEquals((Integer) 100, momsCar.fillTank(60));
	}
}
