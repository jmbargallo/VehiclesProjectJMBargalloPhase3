package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}


	public void addWheels(List<Wheel> frontWheel, List<Wheel> backWheel) {
		this.wheels.add(frontWheel.get(0));
		this.wheels.add(backWheel.get(0));
	}
}
