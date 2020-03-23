package Step_Project_1.controller;

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

  // menu - 1 - show Online-Board
  public String showAllFlights() {
    List<String> allFlights = flightService.getAllFlights();
    return allFlights.size() != 0 ? String.join("\n", allFlights) : "Flight not found";
  }

  // menu - 2 - show flight by id
  public String getFlightById() {
    try {
      console.print("Enter flight id: ");
      return flightService.getFlightById(Integer.parseInt(console.readLn()));
    } catch (NumberFormatException ex) {
      return "You entered non integer value!\n";
    } catch (FlightNotFoundException ex) {
      return "No flight found";
    }
  }

  // menu - 3.1 - searching for appropriate bookable flight
  public String searchForBook(String dest, LocalDate date, int numOfPeople) {
    List<String> result = flightService.searchForBook(dest.toLowerCase(), date, numOfPeople);
    if (result.size() == 0) throw new FlightNotFoundException();
    else return String.join("\n", result);
  }

  public void addFlight() {
    flightService.addFlight();
  }

  public void makeChangesForBooking(int flightId, List<Passenger> passengers) {
    flightService.makeChangesForBooking(flightId, passengers);
  }
}
