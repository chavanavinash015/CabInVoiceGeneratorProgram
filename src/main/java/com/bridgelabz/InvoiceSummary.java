package com.bridgelabz;

public class InvoiceSummary {


    private final double numOfRides;
    private final double totalFare;
    private final double fareAverage;


    public InvoiceSummary(double numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.fareAverage = this.totalFare/this.numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return (numOfRides == that.numOfRides && Double.compare(totalFare, that.totalFare) == 0 && Double.compare(fareAverage, that.fareAverage) == 0);

    }

    public double getNumOfRides() {
        return numOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getFareAverage() {
        return fareAverage;
    }
}
