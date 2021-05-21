package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.SegmentFilter;
import com.gridnine.testing.service.SegmentFilterImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SegmentFilterImplTest {

    List<Flight> testFlights;
    SegmentFilter segmentFilter = new SegmentFilterImpl();

    @BeforeEach
    void setUp() {
        testFlights = FlightTestData.getList();
    }

    @AfterEach
    void tearDown() {
        testFlights = null;
    }

    @Test
    public void departureBeforeCurrentDate(){
        List<Flight> expected = new ArrayList<>(testFlights);
        List<Flight> actual = segmentFilter.departureBeforeCurrentDate(testFlights);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void arrivalBeforeDepartureDate() {
        List<Flight> expected = new ArrayList<>(testFlights);
        List<Flight> actual = segmentFilter.arrivalBeforeDepartureDate(testFlights);
        expected.remove(4);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void transferTimeExceedTwoHours() {
        List<Flight> expected = new ArrayList<>(testFlights);
        List<Flight> actual = segmentFilter.transferTimeExceedTwoHours(testFlights);
        expected.remove(3);
        Assertions.assertIterableEquals(expected, actual);
    }
}
