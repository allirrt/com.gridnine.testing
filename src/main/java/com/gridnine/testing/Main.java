package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();
        flightFilter.setFlights(flights);
        System.out.println("\n  Рейсы по расписанию:");
        mainFligts(flights);

        flightFilter.setFilter(new ExcludeDepartureUntilCurrentTime());
        mainFligts(flightFilter.executeFilter());

        flightFilter.setFilter(new ExcludeBeforeDepartureDate());
        mainFligts(flightFilter.executeFilter());

        flightFilter.setFilter(new ExcludeTimeExceedsTwoHours());
        mainFligts(flightFilter.executeFilter());
    }

    public static void mainFligts(List<Flight> list) {
        for (Flight flight : list) {
            System.out.println(flight);
        }
    }

}

