package com.vehicles.project;

import com.vehicles.clientIO.UserVehicleInformation;

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        UserVehicleInformation userVehicle = new UserVehicleInformation();
        List<Wheel> frontWheels = new ArrayList<>();
        List<Wheel> backWheels = new ArrayList<>();

        //ask user if he/she wants to enter the information for a bike or a car.

        switch (userVehicle.askVehicleType()) {

            case "car":
                Car car = new Car(userVehicle.askPlateToUser(), userVehicle.askBrandToUser(), userVehicle.askColorToUser());

                frontWheels = userVehicle.askWheels("front");
                backWheels = userVehicle.askWheels("back");

                car.addWheels(frontWheels, backWheels);
                userVehicle.printCarInfo(car);
                break;

            case "bike":
                Bike bike = new Bike("No plate", userVehicle.askBrandToUser(), userVehicle.askColorToUser());
                //in this case we use askWheel (only 1 wheel), it's another method.
                frontWheels = userVehicle.askWheel("front");
                backWheels = userVehicle.askWheel("back");

                bike.addWheels(frontWheels.get(0), backWheels.get(0));
                userVehicle.printBikeInfo(bike);

                break;
        }
    }
}
