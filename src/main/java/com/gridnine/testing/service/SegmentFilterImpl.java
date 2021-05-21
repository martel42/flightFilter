package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that implements basic filtering methods.
 */

public class SegmentFilterImpl implements SegmentFilter{
    @Override
    public List<Flight> departureBeforeCurrentDate(List<Flight> flights) {
        List<Flight> filteredList = new ArrayList<>(flights);
        LocalDateTime currentDate = LocalDateTime.now();

//       flights.forEach(flight ->
//                   flight.getSegments().forEach(
//                                   segment -> {
//                                       if (segment.getDepartureDate().isBefore(currentDate))
//                                           filteredList.remove(flight);
//                                   }
//                           ));

        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(currentDate)) {
                    filteredList.remove(flight);
                }
            }
        }

        return filteredList;
    }

    @Override
    public List<Flight> arrivalBeforeDepartureDate(List<Flight> flights) {
        List<Flight> filteredList = new ArrayList<>(flights);

//        flights.forEach(flight ->
//                flight.getSegments().forEach(
//                        segment -> {
//                            if (segment.getArrivalDate().isBefore(segment.getDepartureDate()))
//                                filteredList.remove(flight);
//                        }
//                ));

        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    filteredList.remove(flight);
                }
            }
        }

        return filteredList;
    }

    @Override
    public List<Flight> transferTimeExceedTwoHours(List<Flight> flights) {
        List<Flight> filteredList = new ArrayList<>(flights);

//        flights.forEach(flight ->
//                flight.getSegments().forEach(
//                        segment -> {
//                            int groundTime = 0;
//                            groundTime += Math.abs(Duration.between(segment.getArrivalDate(), segment.getDepartureDate()).toHours());
//                            if (groundTime < 2){
//                                filteredList.remove(flight);
//                            }
//                        }
//                ));

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            int groundTime = 0;
            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    groundTime += Math.abs(Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours());
                }
                if (groundTime > 2) {
                    filteredList.remove(flight);
                }
            }
        }

        return filteredList;
    }
}
