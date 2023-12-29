package org.example;

public class CabInvoiceGenerator {
    private static final double NORMAL_COST_PER_KM = 10.0;
    private static final double NORMAL_COST_PER_MINUTE = 1.0;
    private static final double NORMAL_MINIMUM_FARE = 5.0;

    private static final double PREMIUM_COST_PER_KM = 15.0;
    private static final double PREMIUM_COST_PER_MINUTE = 2.0;
    private static final double PREMIUM_MINIMUM_FARE = 20.0;

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        int totalRides = 0;

        for (Ride ride : rides) {
            totalFare += calculateinvoiceFare(ride.getDistance(), ride.getTime(), ride.getType());
            totalRides++;
        }

        double averageFare = totalRides > 0 ? totalFare / totalRides : 0;

        return new InvoiceSummary(totalRides, totalFare, averageFare);
    }

    private double calculateinvoiceFare(double distance, double time, String type) {
        switch (type) {
            case "NORMAL":
                return calculateNormalFare(distance, time);
            case "PREMIUM":
                return calculatePremiumFare(distance, time);
            default:
                throw new IllegalArgumentException("Invalid ride type");
        }
    }

    public double calculateNormalFare(double distance, double time) {
        double totalFare = distance * NORMAL_COST_PER_KM + time * NORMAL_COST_PER_MINUTE;
        return Math.max(totalFare, NORMAL_MINIMUM_FARE);
    }

    public double calculatePremiumFare(double distance, double time) {
        double totalFare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MINUTE;
        return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
    }
}
