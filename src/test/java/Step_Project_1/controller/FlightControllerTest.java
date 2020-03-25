package Step_Project_1.controller;

import Step_Project_1.dao.DAOFlightFileText;
import Step_Project_1.entity.Flight;
import Step_Project_1.io.Console;
import Step_Project_1.io.ConsoleMain;
import Step_Project_1.service.FlightService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class FlightControllerTest {
  private final String filename = "flights_text.txt";
  private final DAOFlightFileText daoFlight = new DAOFlightFileText(filename);
  private final Console console = new ConsoleMain();
  private final FlightService flightService = new FlightService(daoFlight);
  private final FlightController flightController = new FlightController(console, flightService);

  @org.junit.jupiter.api.Test
  void showMenu() {
    String expected = new StringBuilder()
            .append("1. Online - board\n")
            .append("2. Show the flight info\n")
            .append("3. Search and book a flight\n")
            .append("4. Cancel the booking\n")
            .append("5. My flights\n")
            .append("6. Exit")
            .toString();
    String actual = flightController.showMenu();
    assertEquals(expected, actual);
  }

  @org.junit.jupiter.api.Test
  void showAllFlights() {
    LocalTime time = LocalTime.parse(LocalTime.now().minusHours(8)
            .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    LocalDate date = LocalDate.now().plusDays(1);
    Flight flight = new Flight("Moscow", date, time, 65, filename);
    flightController.addFlight(flight);
    String expected = flight.represent();
    String actual = flightController.showAllFlights();
    assertEquals(expected, actual);
  }

  @org.junit.jupiter.api.Test
  void getFlightById() {
    LocalTime time = LocalTime.parse(LocalTime.now().minusHours(8)
            .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    LocalDate date = LocalDate.now().plusDays(25);
    Flight flight = new Flight("Baku", date, time, 100, filename);
    flightController.addFlight(flight);
    String expected = flight.represent();
    String actual = flightController.getFlightById(3);
    assertEquals(expected, actual);
  }

  @org.junit.jupiter.api.Test
  void searchForBook() {
    LocalTime time = LocalTime.parse(LocalTime.now().minusHours(3)
            .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    LocalDate date = LocalDate.now().plusDays(12);
    Flight flight = new Flight("Berlin", date, time, 100, filename);
    flightController.addFlight(flight);
    String expected = flight.represent();
    String actual = flightController.searchForBook("Berlin", date, 3);
    assertEquals(expected, actual);
  }

  @Test
  void isFlightsFileEmptyTest() {
    assertFalse(flightController.isFlightsFileEmpty());
  }
}