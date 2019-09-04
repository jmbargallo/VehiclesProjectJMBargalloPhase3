package com.vehicles.project;

import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public Car() {
		super();
	}


	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);
		try {
			if (!rightWheel.equals(leftWheel))
					//(rightWheel.getBrand().equals(leftWheel.getBrand()) && (rightWheel.getDiameter() == leftWheel.getDiameter()))
				throw new Exception("The right and the left wheels are not equals");
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
}
