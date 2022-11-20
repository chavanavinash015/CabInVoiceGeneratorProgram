package com.bridgelabz;

public class InvoiceGenerator {


    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double COST_PER_MINUTE = 1;

    public double calculateFare(double distance, double time) {

        return (distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE);
    }
}
