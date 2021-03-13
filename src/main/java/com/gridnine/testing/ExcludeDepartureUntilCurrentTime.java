package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExcludeDepartureUntilCurrentTime implements FilterFlights {
    private final LocalDateTime now = LocalDateTime.now();

    @Override
    public List<Flight> listFilterFlights(List<Flight> flightList) {
        LocalDateTime localDateTime = LocalDateTime.now();
       List<Flight> list = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (localDateTime.isBefore(segment.getDepartureDate())) {
                    list.add(flight);
                    break;
                }
            }
        }
        System.out.println("\n   Bылет до текущего момента времени: ");
        return list;
    }
}



