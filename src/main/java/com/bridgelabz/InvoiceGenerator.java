package com.bridgelabz;

import java.util.HashMap;

public class InvoiceGenerator {


    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double COST_PER_MINUTE = 1.0;
    private static final double MINIMUM_FARE = 5.0;
    public static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15;
    public static final double COST_PER_TIME_PREMIUM = 2.0;
    public static final double MINIMUM_FARE_PREMIUM = 20.0;
    private HashMap<String, Ride[]> rideRepository = new HashMap<>();


    public double calculateFare(double distance, double time) {
        double fare = (distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE);
        return Math.max(fare, MINIMUM_FARE);
    }

    public double calculateTotalFare(Ride[] rides) {
        double aggregateFare = 0;
        for(Ride ride : rides) {
            aggregateFare = aggregateFare + this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return aggregateFare;
    }

    public InvoiceSummary calculateFare1(Ride[] rides) {
        double fareTotal = 0;
        for(Ride ride : rides) {
            fareTotal = fareTotal + this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, fareTotal);
    }

    public void addRides(String userID, Ride[] rides) {
        rideRepository.put(userID, rides);
    }

    public InvoiceSummary getRides(String userID) {
      return calculateFare1(rideRepository.get(userID));
    }

    public double calculateFare(double distance, int time, String type) {

        if (type.equalsIgnoreCase("Normal")) {
            double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE;
            return Math.max(totalFare, MINIMUM_FARE);
        } else if (type.equalsIgnoreCase("Premium")) {
            double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
            return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
        } else {
            System.out.println("Please Enter Proper Customer Type");
            return 0.0;
        }
    }

    public double calculateFare(Ride[] rides, String type) {
        double totalFare = 0.0;
        if (type.equalsIgnoreCase("Normal")) {
            for (Ride r : rides) {
                totalFare += calculateFare(r.getDistance(), r.getTime(), type);
            }
            return totalFare;

        } else if (type.equalsIgnoreCase("Premium")) {
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);

            }
            return totalFare;
        } else
            System.out.println("Please Enter Proper Customer Type");
        return 0.0;
    }

    private double calculateFare(double distance, double time, String type) {

        return distance;
    }

    public InvoiceSummary calculateTotalFare(Ride[] rides, String type) {
        double totalFare = 0.0;
        if (type.equalsIgnoreCase("Normal")) {
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
            }
        } else if (type.equalsIgnoreCase("Premium")) {
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
            }
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
