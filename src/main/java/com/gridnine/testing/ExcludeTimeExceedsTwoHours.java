package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ExcludeTimeExceedsTwoHours implements FilterFlights {
    @Override
    public List<Flight> listFilterFlights(List<Flight> flightList) {
        List<Flight> list = new ArrayList<>();
        for (Flight fl : flightList) {
            int size = fl.getSegments().size();
            if (size > 1) {
                int counter = 0;
                for (int i = 1; i < size; i++) {
                    counter += chronoUnit(fl.getSegments().get(i - 1).getArrivalDate(),
                            fl.getSegments().get(i).getDepartureDate());
                }
                if (counter <= 2) {
                    list.add(fl);
                }
            } else {
                list.add(fl);
            }
        }
        System.out.println("\n  Общее время, проведённое на земле превышает два часа " +
                "(время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним): ");
        return list;
    }

    public int chronoUnit(LocalDateTime arrival, LocalDateTime departure) {
        return (int) ChronoUnit.HOURS.between(arrival, departure);
    }
}
