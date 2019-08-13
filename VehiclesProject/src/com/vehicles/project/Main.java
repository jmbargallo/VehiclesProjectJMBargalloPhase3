package com.vehicles.project;

import com.vehicles.clientIO.UserVehicleInformation;

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        UserVehicleInformation userVehicle = new UserVehicleInformation();

        //ask user if he/she wants to enter the information of a bike or a car.

        if (userVehicle.askVehicleType() == "car") {
            //ask user for the information of her or his car plate, car brand and color of the car.
            Car car = new Car(userVehicle.askPlateToUser(), userVehicle.askBrandToUser(), userVehicle.askColorToUser());

            Wheel frontWheel = userVehicle.askFrontWheel();
            Wheel backWheel = userVehicle.askBackWheel();

            List<Wheel> frontWheels = new ArrayList<>();
            frontWheels.add(frontWheel);
            frontWheels.add(frontWheel);

            List<Wheel> backWheels = new ArrayList<>();
            backWheels.add(backWheel);
            backWheels.add(backWheel);

            try {
                car.addWheels(frontWheels, backWheels);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(car.getPlate() + " " + car.getBrand() + " " + car.getColor() + " " + car.getWheels());
        }else{
            Bike bike = new Bike ("No plate",userVehicle.askBrandToUser(), userVehicle.askColorToUser());
            Wheel frontWheel = userVehicle.askFrontWheel();
            Wheel backWheel = userVehicle.askBackWheel();

            List<Wheel> frontWheels = new ArrayList<>();
            frontWheels.add(frontWheel);

            List<Wheel> backWheels = new ArrayList<>();
            backWheels.add(backWheel);

            try {
                bike.addWheels(frontWheels, backWheels);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
