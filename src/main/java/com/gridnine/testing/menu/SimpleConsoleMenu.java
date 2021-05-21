package com.gridnine.testing.menu;

import com.gridnine.testing.model.Flight;

import java.util.List;

/**
 *Class that displays a console menu.
 */

public class SimpleConsoleMenu {
    public static void showMenu(){
        System.out.println("""
                Choose the filter:
                1 - Exclude from the list flights up to the current time
                2 - Exclude from the list flights where there are segments with an arrival date earlier than the departure date
                3 - Exclude from the list flights in which the total time spent on the ground exceeds two hours""");
    }

    public static void showFlights(List<Flight> flights){
        for (Flight flight : flights) {
            System.out.println("------------------------------------------------------------------");
            System.out.println(flight);
            System.out.println("------------------------------------------------------------------");
        }
    }


}

