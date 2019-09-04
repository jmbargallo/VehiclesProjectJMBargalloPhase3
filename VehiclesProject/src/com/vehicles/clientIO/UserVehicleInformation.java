package com.vehicles.clientIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Wheel;

public class UserVehicleInformation {
    public static Scanner scanner = new Scanner((System.in));

    public String askPlateToUser() throws Exception {
        System.out.println("Which is the plate of your car? \nPlease enter the number and letters with the slash symbol '-'");
        String plate = scanner.nextLine();
        // check the plate information should be X-1234-YZ (length = 8) or 1234-XYZ (length = 9)
        // we check the length and the structure of the plate
        while (!(areThePlateLengthCorrect(plate) && areThePlateStructureCorrect(plate))) {
            plate = askAgainThePlate();
        }
        return plate;
    }

    private boolean areThePlateStructureCorrect(String plate) {
        String[] out = plate.split("-");

        // check if it is the first class of structure X-1234-YZ
        if (out.length == 3) {
            if (!out[0].matches("[a-zA-Z]+"))
                return false;
            if (!out[1].matches("[0-9]+"))
                return false;
            if (!out[2].matches("[a-zA-Z]+"))
                return false;
            return true;
        }

        // check if it is the second class of structure 1234-XYZ
        if (out.length == 2) {
            if (!out[0].matches("[0-9]+"))
                return false;
            if (!out[1].matches("[a-zA-Z]+"))
                return false;
            return true;
        }
        return false;
    }

    public String askVehicleType() {
        System.out.println("Do you want to enter a car or a bike?");
        String input = scanner.nextLine();

        while (!(input.equals("car") || input.equals("bike"))) {
            System.out.println("Please, which kind of vehicle do you want to enter? A car or a bike?");
            input = scanner.nextLine();
        }

        return input;
    }


    private String askAgainThePlate() throws Exception {

        System.out.println("Please remember that the plate must have 4 digits and 3 letters, otherwise, " +
                "it must be like X-1234-YZ or 1234-XYZ");
        System.out.println("Do you want to try it again? Please answer yes or no");

        String input = scanner.nextLine();

        while (!input.equals("yes")) {
            if (input.equals("no")) {
                System.out.println("If you don't want to give us the correct plate car license we can't create " +
                        "a the new car in our database. " +
                        "For this reason the application is going to stop running now");
                System.exit(0);
            }
            System.out.println("Do you want to try it again? Please input yes or no");
            input = scanner.nextLine();
        }

        System.out.println("Which is the plate of your vehicle? Please enter the number and letters with the slash symbol '-'");
        return scanner.nextLine();
    }

    private boolean areThePlateLengthCorrect(String plate) {

        if (plate.length() != 8) {
            return plate.length() == 9;
        }
        return true;
    }

    public String askBrandToUser() {
        System.out.println("Which is the brand of your vehicle?");
        return (scanner.nextLine());
    }

    public String askColorToUser() {
        System.out.println("Which is the color of your vehicle?");
        return (scanner.nextLine());
    }

    public List<Wheel> askWheels(String location) {
        UserVehicleInformation userVehicle = new UserVehicleInformation();
        List<Wheel> wheels = new ArrayList<>();

        Wheel leftWheel = new Wheel(
                userVehicle.askBrandWheelsToUser(location,"left"),
                userVehicle.askDiameterWheelsToUser(location,"left")
        );
        wheels.add(leftWheel);
        Wheel rightWheel = new Wheel(
                userVehicle.askBrandWheelsToUser(location,"right"),
                userVehicle.askDiameterWheelsToUser(location,"right")
        );
        wheels.add(rightWheel);
        return wheels;
    }


    private String askBrandWheelsToUser(String wheelsLocation, String position ) {
            System.out.println("Which is the brand of the " + position + " " + wheelsLocation + " wheel of your vehicle?");
            return (scanner.nextLine());
    }


    public double askDiameterWheelsToUser(String wheelsLocation, String position) {

        System.out.println("Which is the diameter of the vehicle " + position + " " + wheelsLocation + " wheel?");
        String input = scanner.nextLine();
        while ((Double.parseDouble(input) <= 0.4) || (Double.parseDouble(input) >= 4)) {
            System.out.println("We only accept diameters from 0.4 to 4. Please, enter again the diameter of the vehicle " + position + " " + wheelsLocation + " wheel");
            input = scanner.nextLine();
        }
        return Double.parseDouble(input);
    }


    public UserVehicleInformation() {

    }

    public List<Wheel> askWheel(String location) {
        List<Wheel> wheels = new ArrayList<>();
        UserVehicleInformation userVehicle = new UserVehicleInformation();

        Wheel wheel = new Wheel(
                userVehicle.askBrandWheelsToUser(location,""),
                userVehicle.askDiameterWheelsToUser(location,"")
        );
        wheels.add(wheel);

        return wheels;
    }

    public void printCarInfo(Car car) {
        System.out.println(car.getPlate() + " " + car.getBrand() + " " + car.getColor());
        for (Wheel wheel : car.getWheels()) {
            System.out.print(wheel.getBrand() + " " + wheel.getDiameter());
        }
    }


    public void printBikeInfo(Bike bike) {
        System.out.println(bike.getPlate() + " " + bike.getBrand() + " " + bike.getColor());
        for (Wheel wheel : bike.getWheels()) {
            System.out.print(wheel.getBrand() + " " + wheel.getDiameter());
        }
    }
}