package Step_Project_1.service;

import Step_Project_1.dao.DAOFlightFileText;
import Step_Project_1.entity.Flight;
import Step_Project_1.ex.FlightNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {
  private final String filename = "flights_test_S";
  DAOFlightFileText daoFlight = new DAOFlightFileText(filename);
  FlightService flightService = new FlightService(daoFlight);

  @Test
  void showMenu() {
    String expected = new StringBuilder().append("1. Online - board\n")
            .append("2. Show the flight info\n")
            .append("3. Search and book a flight\n")
            .append("4. Cancel the booking\n")
            .append("5. My flights\n")
            .append("6. Exit")
            .toString();
    String actual = flightService.showMenu();
    assertEquals(expected, actual);
  }

  @Test
  void getAllFlights() {
    String expected = "[]";
    String actual = flightService.getAllFlights().toString();
    assertEquals(expected, actual);
  }

  @Test
  void getFlightById() {
    LocalTime time = LocalTime.parse(LocalTime.now().minusHours(8)
            .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    LocalDate date = LocalDate.now().plusDays(1);
    Flight flight = new Flight("NewYork", date, time, 65, filename);
    flightService.addFlight(flight);
    String expected = flight.represent();
    String actual = flightService.getFlightById(2);
    assertEquals(expected, actual);
  }

  @Test
  void searchForBook() {
    LocalTime time = LocalTime.parse(LocalTime.now().minusHours(27)
            .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    LocalDate date = LocalDate.now().plusDays(39);
    Flight flight = new Flight("NewCity", date, time, 40, filename);
    flightService.addFlight(flight);
    String expected = flight.represent();
    String actual = flightService.searchForBook("NewCity", date, 5).toString();
  }
}