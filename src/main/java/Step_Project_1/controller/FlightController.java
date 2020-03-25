package Step_Project_1.controller;

import Step_Project_1.entity.Flight;
import Step_Project_1.entity.Passenger;
import Step_Project_1.ex.FlightNotFoundException;
import Step_Project_1.io.Console;
import Step_Project_1.service.FlightService;

import java.time.LocalDate;
import java.util.List;

public class FlightController {
  private final FlightService flightService;
  private final Console console;

  public FlightController(Console console, FlightService flightService) {
    this.flightService = flightService;
    this.console = console;
  }

  public boolean isFlightsFileEmpty() {
    return flightService.isFlightsFileEmpty();
  }

  public String showMenu() {
    return flightService.showMenu();
  }

  public String showAllFlights() {
    List<String> allFlights = flightService.getAllFlights();
    return allFlights.size() != 0 ? String.join("\n", allFlights) : "Flight not found";
  }

  public String getFlightById(int flightId) {
    return flightService.getFlightById(flightId);
  }

  public String searchForBook(String dest, LocalDate date, int numOfPeople) {
    List<String> result = flightService.searchForBook(dest.toLowerCase(), date, numOfPeople);
    if (result.size() == 0) throw new FlightNotFoundException();
    else return String.join("\n", result);
  }

  public void makeChangesForBooking(int flightId, List<Passenger> passengers) {
    flightService.makeChangesForBooking(flightId, passengers);
  }

  public void genFlights() {
    flightService.genFlights();
  }

  public void addFlight(Flight flight) {
    flightService.addFlight(flight);
  }
}
