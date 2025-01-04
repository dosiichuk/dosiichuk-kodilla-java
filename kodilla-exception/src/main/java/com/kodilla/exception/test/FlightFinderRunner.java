package com.kodilla.exception.test;

public class FlightFinderRunner {

    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();

        Flight flight1 = new Flight("Warsaw", "Berlin");
        Flight flight2 = new Flight("Warsaw", "Paris");

        try {
            flightFinder.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("Exception: " + e);
        }

        try {
            flightFinder.findFlight(flight2);
        } catch (RouteNotFoundException e) {
            System.out.println("Exception: " + e);
        }
    }
}
