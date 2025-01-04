package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    private Map<String, Boolean> airports = new HashMap<>();

    public FlightFinder() {

    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        airports.put("Warsaw", true);
        airports.put("Berlin", false);
        airports.put("Paris", true);
        airports.put("London", true);

        if (airports.containsKey(flight.getArrivalAirport()) && airports.get(flight.getArrivalAirport())) {
            System.out.println("Flight to " + flight.getArrivalAirport() + " is available.");
        } else {
            throw new RouteNotFoundException("Flight to " + flight.getArrivalAirport() + " is not available.");
        }
    }
}
