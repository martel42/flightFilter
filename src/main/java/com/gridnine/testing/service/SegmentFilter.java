package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface that declares the basic filtering methods.
 */

public interface SegmentFilter {

    List<Flight> departureBeforeCurrentDate(List<Flight> flights);

    List<Flight> arrivalBeforeDepartureDate(List<Flight> flights);

    List<Flight> transferTimeExceedTwoHours(List<Flight> flights);

}
