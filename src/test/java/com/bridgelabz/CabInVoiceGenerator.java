package com.bridgelabz;

import org.junit.jupiter.api.*;

public class CabInVoiceGenerator {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @BeforeAll
    public static void displayMethod(){
        System.out.println("Welcome to the Cab In Voice Generator Program");

    }

    @AfterEach
     public void afterDisplayMethod(){
        System.out.println("Test is Pass/Run");
    }
    @Test
    public void givenDistanceAndTime_InvoiceGenerator_ShouldReturnFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        double time = 4.0;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(24.0, fare, 0.0);
    }
    @Test
    public void givenDistanceAndTime_InvoiceGenerator_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 4.0;
        double time = 2.0;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(42.0, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnAggregateFare() {

        Ride[] rides = {new Ride(2.0, 5.0), new Ride(0.1, 1.0)};
        double fare = invoiceGenerator.calculateTotalFare(rides);
        Assertions.assertEquals(27.0, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(5.0, 5.0), new Ride(0.1, 1.0)};
        InvoiceSummary summary = invoiceGenerator.calculateFare1(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2.0, 60.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
}
