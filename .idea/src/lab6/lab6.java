package lab6;

import lab5.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class to demonstrate the functionality of the TrainSet collection.
 */
public class lab6 {
    public static void main(String[] args) {
        System.out.println("--- DEMONSTRATION OF TrainSet (Variant 7) ---");

        System.out.println("\n1. Testing empty constructor:");
        TrainSet<RailVehicle> train1 = new TrainSet<>();
        System.out.println("Train is empty? " + train1.isEmpty());

        RailVehicle car1 = new BusinessClassRailVehicle(30);
        train1.add(car1);
        train1.add(new EconomyClassRailVehicle(50));
        System.out.println("Train size after adding 2 cars: " + train1.size());

        System.out.println("Attempting to add a duplicate car...");
        boolean added = train1.add(car1);
        System.out.println("Was the duplicate added? " + added);
        System.out.println("Final size: " + train1.size());

        System.out.println("\n2. Testing constructor with a single car (using static factory method):");
        TrainSet<RailVehicle> train2 = TrainSet.of(new BaggageRailVehicle(5000));
        System.out.println("Train size: " + train2.size());
        System.out.println("Contents of train2: " + train2);

        System.out.println("\n3. Testing constructor with a standard collection:");
        List<RailVehicle> standardList = new ArrayList<>();
        standardList.add(new BusinessClassRailVehicle(25));
        standardList.add(new EconomyClassRailVehicle(48));
        standardList.add(new BusinessClassRailVehicle(25));

        System.out.println("Standard list size (with duplicates): " + standardList.size());
        TrainSet<RailVehicle> train3 = new TrainSet<>(standardList);
        System.out.println("TrainSet size (duplicates ignored): " + train3.size());

        System.out.println("\n4. Testing business logic on train1:");
        System.out.println("Total passengers in train1: " + train1.calculateTotalPassengers());
        System.out.println("Total baggage in train1: " + train1.calculateTotalBaggage() + " kg");

        TrainSet<RailVehicle> foundCars = train1.findCarsByPassengerRange(40, 60);
        System.out.println("Cars with 40-60 passengers: " + foundCars);

        System.out.println("\nIterating through train3 cars:");
        for (RailVehicle car : train3) {
            System.out.println(car);
        }
    }
}