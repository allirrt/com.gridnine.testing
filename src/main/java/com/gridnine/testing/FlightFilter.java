package com.gridnine.testing;

import java.util.List;

public class FlightFilter {
    private FilterFlights filterFlights;
    private List<Flight> flights;

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void setFilter(FilterFlights filterFlights) {
        this.filterFlights = filterFlights;
    }

    public List<Flight> executeFilter() {
        return filterFlights.listFilterFlights(flights);
    }
}
