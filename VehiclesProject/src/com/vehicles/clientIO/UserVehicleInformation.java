package com.vehicles.clientIO;

import java.util.Scanner;

import com.vehicles.project.Wheel;

public class UserVehicleInformation {


    public String askPlateToUser() throws Exception {
        Scanner scanner = new Scanner((System.in));
        System.out.println("Which is the plate of your car? Please enter the number and letters with the slash symbol '-'");
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

        public String askVehicleType(){
            Scanner scanner = new Scanner((System.in));

            System.out.println("Do you want to enter a car or a bike?");
            String input = scanner.nextLine();
            while (!(input.equals("car") || input.equals("bike"))){
                System.out.println("Please, which kind of vehicle do you want to enter? A car or a bike?");
                input = scanner.nextLine();
            }
            return input;
        }


        private String askAgainThePlate () throws Exception {
            String plate;
            Scanner scanner = new Scanner((System.in));

            System.out.println("Please remember that the plate must have 4 digits and 3 letters, otherwise, " +
                    "it must be like X-1234-YZ or 1234-XYZ");
            System.out.println("Do you want to try it again? Please input Yes or No");
            String input = scanner.nextLine();
            while (input.equals("Yes")) {
                if (input.equals("No")) {
                    System.out.println("If you don't want to give us the correct plate car license we can't create " +
                            "a the new car in our database. " +
                            "For this reason the application is going to stop running now");
                    //TODO Break and go out of the application.
                }
                System.out.println("Do you want to try it again? Please input Yes or No");
                input = scanner.nextLine();
            }
            System.out.println("Which is the plate of your car? Please enter the number and letters with the slash symbol '-'");
            plate = scanner.nextLine();
            return plate;
        }

        private boolean areThePlateLengthCorrect (String plate){
            Scanner scanner = new Scanner((System.in));

            if (plate.length() != 8) {
                return plate.length() == 9;
            }
            return true;
        }

        public String askBrandToUser () {
            Scanner scanner = new Scanner((System.in));
            System.out.println("Which is the brand of your car?");
            return (scanner.nextLine());
        }

        public String askColorToUser () {
            Scanner scanner = new Scanner((System.in));
            System.out.println("Which is the color of your car?");
            return (scanner.nextLine());
        }

        public Wheel askFrontWheel () {
            UserVehicleInformation userVehicle = new UserVehicleInformation();
            Wheel frontWheel = new Wheel(
                    userVehicle.askBrandWheelsToUser("front"),
                    userVehicle.askDiameterWheelsToUser("front")
            );
            return frontWheel;
        }

        public Wheel askBackWheel () {
            UserVehicleInformation userVehicle = new UserVehicleInformation();
            Wheel backWheel = new Wheel(
                    userVehicle.askBrandWheelsToUser("back"),
                    userVehicle.askDiameterWheelsToUser("back")
            );
            return backWheel;
        }

        private String askBrandWheelsToUser(String wheelsLocation){
            Scanner scanner = new Scanner((System.in));
            if (wheelsLocation == "front") {
                System.out.println("Which is the brand of the car front wheels?");
                return (scanner.nextLine());
            }
            System.out.println("Which is the brand of the car back wheels?");
            return (scanner.nextLine());
        }

        public double askDiameterWheelsToUser (String wheelsLocation){
            Scanner scanner = new Scanner((System.in));

            if (wheelsLocation == "front") {
                System.out.println("Which is the diameter of the vehicle front wheels?");
                String input = scanner.nextLine();
                while((Double.parseDouble(input) <= 0.4) || (Double.parseDouble(input) >= 4)){
                    System.out.println("We only accept diameters from 0.4 to 4. Please, enter again the diameter of the car front wheels");
                    input = scanner.nextLine();
                }
                return Double.parseDouble(input);
            }
            System.out.println("Which is the diameter of the vehicle back wheels?");
            String input = scanner.nextLine();
            while((Double.parseDouble(input) <= 0.4) || (Double.parseDouble(input) >= 4)){
                System.out.println("We only accept diameters from 0.4 to 4. Please, enter again the diameter of the car back wheels");
                input = scanner.nextLine();
            }
            return Double.parseDouble(input);
        }


    public UserVehicleInformation() {
        }

    }