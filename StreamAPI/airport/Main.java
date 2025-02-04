package StreamAPI.airport;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        System.out.println("Number of Airbus A-320 aircraft: " + findCountAircraftWithModelAirbus(airport, "Airbus A-320"));

        System.out.println("Number of parked aircraft by terminal:");
        findMapCountParkedAircraftByTerminalName(airport).forEach((terminal, count) ->
                System.out.println(terminal + ": " + count));

        System.out.println("Flights departing in the next 3 hours:");
        findFlightsLeavingInTheNextHours(airport, 3).forEach(System.out::println);

        String terminalName = "A";
        Optional<Flight> flight = findFirstFlightArriveToTerminal(airport, terminalName);
        flight.ifPresentOrElse(
                f -> System.out.println("Nearest flight to terminal " + terminalName + ": " + f),
                () -> System.out.println("No flights to terminal " + terminalName)
        );
    }

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        return airport.getAllAircrafts()
                .stream()
                .filter(aircraft -> aircraft.getModel().startsWith(model))
                .count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        return airport.getTerminals().stream()
                .collect(Collectors.toMap(
                        Terminal::getName,
                        terminal -> terminal.getParkedAircrafts().size()
                ));
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        Instant now = Instant.now();
        Instant targetTime = now.plusSeconds(hours* 3600L);

        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight$Type.DEPARTURE
                        && flight.getDate().isAfter(now) && flight.getDate().isBefore(targetTime))
                .collect(Collectors.toList());
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        return airport.getTerminals().stream()
                .filter(terminal -> terminal.getName().equals(terminalName))
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight$Type.ARRIVAL))
                .min(Comparator.comparing(Flight::getDate));
    }
}
