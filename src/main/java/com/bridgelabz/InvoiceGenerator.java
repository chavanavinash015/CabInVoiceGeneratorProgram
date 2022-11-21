package com.bridgelabz;

import java.util.HashMap;

public class InvoiceGenerator {


    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double COST_PER_MINUTE = 1.0;
    private static final double MINIMUM_FARE = 5.0;
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

}
