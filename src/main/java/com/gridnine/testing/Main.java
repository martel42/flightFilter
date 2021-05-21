package com.gridnine.testing;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.menu.SimpleConsoleMenu;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.SegmentFilter;
import com.gridnine.testing.service.SegmentFilterImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        SegmentFilter flightFilter = new SegmentFilterImpl();

        System.out.println("All flights:");
        SimpleConsoleMenu.showFlights(flights);
        SimpleConsoleMenu.showMenu();

        Scanner in = new Scanner(System.in);
        String input = in.next();

        switch (input) {
            case "1" -> SimpleConsoleMenu.showFlights(flightFilter.departureBeforeCurrentDate(flights));
            case "2" -> SimpleConsoleMenu.showFlights(flightFilter.arrivalBeforeDepartureDate(flights));
            case "3" -> SimpleConsoleMenu.showFlights(flightFilter.transferTimeExceedTwoHours(flights));
            default -> System.out.println("Invalid input!");
        }
    }
}
