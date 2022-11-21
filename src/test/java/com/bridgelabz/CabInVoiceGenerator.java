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

    @Test
    public void givenUserID_ShouldReturnListofRidesAndInvoice() {
        String user1 = "Arun";
        Ride[] ridesUser1 = {new Ride(5.0, 5), new Ride(0.1, 1)};
        invoiceGenerator.addRides(user1, ridesUser1);
        InvoiceSummary summaryUser1 = invoiceGenerator.getRides(user1);
        InvoiceSummary expectedInvoiceSummaryUser1 = new InvoiceSummary(2, 60);
        Assertions.assertEquals(expectedInvoiceSummaryUser1, summaryUser1);

        String user2 = "Anil";
        Ride[] ridesUser2 = {new Ride(5.0, 5), new Ride(0.1, 1), new Ride(10, 10), new Ride(1, 20)};
        invoiceGenerator.addRides(user2, ridesUser2);
        InvoiceSummary summaryUser2 = invoiceGenerator.getRides(user2);
        InvoiceSummary expectedInvoiceSummaryUser2 = new InvoiceSummary(4, 200);
        Assertions.assertEquals(expectedInvoiceSummaryUser2, summaryUser2);
    }
}
