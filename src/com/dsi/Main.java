package com.dsi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char option;
        int expectedVistors = 30;
        boolean available = false;
        List<NormalVehicle> normalVehicles = new ArrayList<NormalVehicle>();
        List<SportsVehicle> sportsVehicles = new ArrayList<SportsVehicle>();
        List<HeavyVehicle> heavyVehicles = new ArrayList<HeavyVehicle>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\t\t\t\t\t" + "****Vehicle Showroom****");
            System.out.println("a. Add any type of vehicle in showroom. " + "\n" +
                    "b. Remove any of the vehicles from showroom." + "\n" +
                    "c. Show the vehicle lists with details currently have in showroom. \n" +
                    "d. Show the list of vehicles with current expected visitor count. \n" +
                    "e. Exit");
            System.out.print("Enter the letter on the Left Side for choosing any functionality : ");
            option = scanner.next().charAt(0);
            if (option == 'a' || option == 'A') {
                System.out.print("\t \t - Normal \n" +
                        "\t \t - Sports \n" +
                        "\t \t - Heavy \n" +
                        "Enter the Type of Vehicle you want to add : ");
                String vehicleType = scanner.next();
                if (vehicleType.equalsIgnoreCase("Normal")) {
                    available = false;
                    scanner.nextLine();
                    System.out.print("Enter the Model Number : ");
                    String mn = scanner.nextLine();
                    System.out.print("Enter the Engine Type (Oil/ Gas/ Diesel) : ");
                    String et = scanner.nextLine();
                    System.out.print("Enter the Engine Power : ");
                    String ep = scanner.nextLine();
                    System.out.print("Enter the Tire Size : ");
                    String ts = scanner.nextLine();
                    NormalVehicle normalVehicle = new NormalVehicle(mn, et, ep, ts, expectedVistors);
                    for (NormalVehicle temp : normalVehicles) {
                        if (temp.modelNumber.equals(mn)) {
                            available = true;
                            System.out.println("\t \t---Vehicle with Same Model Number Already Available---");
                            break;
                        }
                    }
                    if(!available) {
                        normalVehicles.add(normalVehicle);
                    }
                } else if (vehicleType.equalsIgnoreCase("Sports")) {
                    available = false;
                    scanner.nextLine();
                    System.out.print("Enter the Model Number : ");
                    String mn = scanner.nextLine();
                    System.out.print("Enter the Engine Power : ");
                    String ep = scanner.nextLine();
                    System.out.print("Enter the Tire Size : ");
                    String ts = scanner.nextLine();
                    System.out.print("Turbocharged Engine (true/false) : ");
                    boolean t = scanner.nextBoolean();
                    SportsVehicle sportsVehicle = new SportsVehicle(mn, ep, ts, t, ((expectedVistors) + ((sportsVehicles.size() + 1) * 20)));
                    for (SportsVehicle temp : sportsVehicles) {
                        if (temp.modelNumber.equals(mn)) {
                            available = true;
                            System.out.println("\t \t---Vehicle with Same Model Number Already Available---");
                            break;
                        }
                    }
                    if(!available) {
                        sportsVehicles.add(sportsVehicle);
                    }
                } else if (vehicleType.equalsIgnoreCase("Heavy")){
                    available = false;
                    scanner.nextLine();
                    System.out.print("Enter the Model Number : ");
                    String mn = scanner.nextLine();
                    System.out.print("Enter the Engine Power : ");
                    String ep = scanner.nextLine();
                    System.out.print("Enter the Tire Size : ");
                    String ts = scanner.nextLine();
                    System.out.print("Enter the weight : ");
                    String w = scanner.nextLine();
                    HeavyVehicle heavyVehicle = new HeavyVehicle(mn, ep, ts, w, expectedVistors);
                    for (HeavyVehicle temp : heavyVehicles) {
                        if (temp.modelNumber.equals(mn)) {
                            available = true;
                            System.out.println("\t \t---Vehicle with Same Model Number Already Available---");
                            break;
                        }
                    }
                    if(!available) {
                        heavyVehicles.add(heavyVehicle);
                    }
                } else {
                    System.out.println("---" + vehicleType + " Vehicle not Available--- ");
                }
            }
            else if (option == 'b' || option == 'B'){
                scanner.nextLine();
                boolean removalCheck = false;
                String modelNumber;
                System.out.println("\t \t - Normal \n" +
                        "\t \t - Sports \n" +
                        "\t \t - Heavy");
                System.out.print("Enter the Type of Vehicle you want to remove : ");
                String removeVehicle = scanner.next();
                scanner.nextLine();
                if(removeVehicle.equalsIgnoreCase("Normal")) {
                    if (!normalVehicles.isEmpty()) {
                        System.out.print("Enter the Model Number of the Vehicle to remove : ");
                        modelNumber = scanner.nextLine();
                        for (NormalVehicle temp : normalVehicles) {
                            if (temp.modelNumber.equals(modelNumber)) {
                                removalCheck = normalVehicles.remove(temp);
                                if (removalCheck) {
                                    System.out.println("\t \t****Successfully Removed****");
                                }
                                break;
                            }
                        }
                        if (!removalCheck) {
                            System.out.println("\t \t---Wrong Model Number. Try Again.---");
                        }
                    }
                    else {
                        System.out.println("\t \t---Normal Vehicle not Available---");
                    }
                }
                else if (removeVehicle.equalsIgnoreCase("Sports")) {
                    if (!sportsVehicles.isEmpty()) {
                        System.out.print("Enter the Model Number of the Vehicle to remove : ");
                        modelNumber = scanner.nextLine();
                        for (SportsVehicle temp : sportsVehicles) {
                            if (temp.modelNumber.equals(modelNumber)) {
                                removalCheck = sportsVehicles.remove(temp);
                                if (removalCheck) {
                                    System.out.println("\t \t****Successfully Removed****");
                                }
                                break;
                            }
                        }
                        if (removalCheck) {
                            SportsVehicle tempSportsVehicle;
                            List<SportsVehicle> tempSportsVehicles = new ArrayList<SportsVehicle>();
                            for (SportsVehicle temp : sportsVehicles) {
                                int tempVisitorCount = ((expectedVistors) + ((tempSportsVehicles.size() + 1) * 20));
                                tempSportsVehicle = new SportsVehicle(temp.modelNumber, temp.enginePower, temp.tireSize, temp.turbo, tempVisitorCount);
                                tempSportsVehicles.add(tempSportsVehicle);
                            }
                            sportsVehicles.clear();
                            sportsVehicles.addAll(tempSportsVehicles);
                        }
                        else {
                            System.out.println("\t \t---Wrong Model Number. Try Again.---");
                        }
                    }
                    else {
                        System.out.println("\t \t---Sports Vehicle not Available---");
                    }
                }
                else if (removeVehicle.equalsIgnoreCase("Heavy")) {
                    if (!heavyVehicles.isEmpty()) {
                        System.out.print("Enter the Model Number of the Vehicle to remove : ");
                        modelNumber = scanner.nextLine();
                        for (HeavyVehicle temp : heavyVehicles) {
                            if (temp.modelNumber.equals(modelNumber)) {
                                removalCheck = heavyVehicles.remove(temp);
                                if (removalCheck) {
                                    System.out.println("\t \t****Successfully Removed****\t \t");
                                }
                                break;
                            }
                        }
                        if (!removalCheck) {
                            System.out.println("\t \t---Wrong Model Number. Try Again.---");
                        }
                    }
                    else {
                        System.out.println("\t \t---Heavy Vehicle not Available---");
                    }
                }
                else {
                    System.out.println("---" + removeVehicle + " Vehicle not Available---");
                }
            }
            else if (option == 'c' || option== 'C'){
                if(normalVehicles.isEmpty() && sportsVehicles.isEmpty() && heavyVehicles.isEmpty()){
                    System.out.println("\t \t---No Vehicle is Available---");
                }
                else {
                    if (!normalVehicles.isEmpty()) {
                        System.out.println("\t \t \t \t \t \t \t \t***Normal Vehicles***");
                        System.out.printf("%20s %20s %20s %20s", "Model Number" , "Engine Type", "Engine Power", "Tire Size");
                        System.out.println();
                        for (NormalVehicle temp : normalVehicles) {
                            System.out.format("%20s %20s %20s %20s", temp.getModelNumber(), temp.getEngineType(), temp.getEnginePower(), temp.getTireSize());
                            System.out.println();
                        }
                        System.out.println("\t \t \t \t \t \t------------------------------------------------------------");
                    }
                    if (!sportsVehicles.isEmpty()) {
                        System.out.println("\t \t \t \t \t \t \t \t***Sports Vehicles***");
                        System.out.printf("%20s %20s %20s %20s %20s", "Model Number", "Engine Type", "Engine Power", "Tire Size", "Turbo");
                        System.out.println();
                        for (SportsVehicle temp : sportsVehicles) {
                            System.out.format("%20s %20s %20s %20s %20s", temp.getModelNumber(), temp.getEngineType(), temp.getEnginePower(), temp.getTireSize(), temp.getTurbo());
                            System.out.println();
                        }
                        System.out.println("\t \t \t \t \t \t------------------------------------------------------------");
                    }
                    if (!heavyVehicles.isEmpty()) {
                        System.out.println("\t \t \t \t \t \t \t \t***Heavy Vehicles***");
                        System.out.printf("%20s %20s %20s %20s %20s", "Model Number", "Engine Type", "Engine Power", "Tire Size", "Weight");
                        System.out.println();
                        for (HeavyVehicle temp : heavyVehicles) {
                            System.out.format("%20s %20s %20s %20s %20s", temp.getModelNumber(), temp.getEngineType(), temp.getEnginePower(), temp.getTireSize(), temp.getWeight());
                            System.out.println();
                        }
                        System.out.println("\t \t \t \t \t \t------------------------------------------------------------");
                    }
                }
            }
            else if (option == 'd' || option== 'D'){
                if(normalVehicles.isEmpty() && sportsVehicles.isEmpty() && heavyVehicles.isEmpty()){
                    System.out.println("\t \t---No Vehicle is Available---");
                }
                else {
                    if (!normalVehicles.isEmpty()) {
                        System.out.println("\t \t \t \t \t \t \t \t***Normal Vehicles***");
                        System.out.printf("%20s %20s %20s %20s %25s", "Model Number", "Engine Type", "Engine Power", "Tire Size", "Expected Visitor Count");
                        System.out.println();
                        for (NormalVehicle temp : normalVehicles) {
                            System.out.format("%20s %20s %20s %20s %25s", temp.getModelNumber(), temp.getEngineType(), temp.getEnginePower(), temp.getTireSize(), temp.getExpectedVisitors());
                            System.out.println();
                        }
                        System.out.println("\t \t \t \t \t \t------------------------------------------------------------");
                    }
                    if (!sportsVehicles.isEmpty()) {
                        System.out.println("\t \t \t \t \t \t \t \t***Sports Vehicles***");
                        System.out.printf("%20s %20s %20s %20s %20s %25s", "Model Number", "Engine Type", "Engine Power", "Tire Size", "Turbo", "Expected Visitor Count");
                        System.out.println();
                        for (SportsVehicle temp : sportsVehicles) {
                            System.out.format("%20s %20s %20s %20s %20s %25s", temp.getModelNumber(), temp.getEngineType(), temp.getEnginePower(), temp.getTireSize(), temp.getTurbo(), temp.getExpectedVisitors());
                            System.out.println();
                        }
                        System.out.println("\t \t \t \t \t \t------------------------------------------------------------");
                    }
                    if (!heavyVehicles.isEmpty()) {
                        System.out.println("\t \t \t \t \t \t \t \t***Heavy Vehicles***");
                        System.out.printf("%20s %20s %20s %20s %20s %25s", "Model Number", "Engine Type", "Engine Power", "Tire Size", "Weight", "Expected Visitor Count");
                        System.out.println();
                        for (HeavyVehicle temp : heavyVehicles) {
                            System.out.format("%20s %20s %20s %20s %20s %25s", temp.getModelNumber(), temp.getEngineType(), temp.getEnginePower(), temp.getTireSize(), temp.getWeight(), temp.getExpectedVisitors());
                            System.out.println();
                        }
                        System.out.println("\t \t \t \t \t \t------------------------------------------------------------");
                    }
                }
            }
            else
                break;
        }
    }
}