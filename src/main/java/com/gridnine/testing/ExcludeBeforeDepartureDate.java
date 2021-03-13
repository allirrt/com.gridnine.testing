package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class ExcludeBeforeDepartureDate implements FilterFlights {
    @Override
    public List<Flight> listFilterFlights(List<Flight> flightList) {
        List<Flight> list = new ArrayList<>();
        for (Flight flights : flightList) {
            for (Segment segments : flights.getSegments()) {
                if (segments.getArrivalDate().isAfter(segments.getDepartureDate())) {
                    list.add(flights);
                    break;
                }
            }
        }
        System.out.println("\n  Имеются сегменты с датой прилёта раньше даты вылета:");
        return list;
    }

}
