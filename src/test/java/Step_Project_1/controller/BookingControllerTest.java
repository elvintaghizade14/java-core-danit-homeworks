package Step_Project_1.controller;

import Step_Project_1.dao.DAOBookingFileText;
import Step_Project_1.dao.DAOFlightFileText;
import Step_Project_1.entity.Booking;
import Step_Project_1.entity.Flight;
import Step_Project_1.entity.Passenger;
import Step_Project_1.io.Console;
import Step_Project_1.io.ConsoleMain;
import Step_Project_1.service.BookingService;
import Step_Project_1.service.FlightService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

class BookingControllerTest {
  private final String bookingFile = "bookings_test_B.txt";
  private final String flightFile = "flights_test_B.txt";
  private Console console = new ConsoleMain();
  private final DAOBookingFileText daoBooking = new DAOBookingFileText(bookingFile);
  private final DAOFlightFileText daoFlight = new DAOFlightFileText(flightFile);
  private final FlightService flightService = new FlightService(daoFlight);
  private final BookingService bookingService = new BookingService(daoBooking);
  private final BookingController bookingController = new BookingController(console, bookingService);

  @Test
  void getMyFlights() {
    LocalTime time = LocalTime.parse(LocalTime.now().minusHours(1)
            .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    LocalDate date = LocalDate.now().plusDays(1);
    Flight flight = new Flight(72, "Ganja", date.plusDays(100), time, 150);
    flightService.addFlight(flight);
    bookingController.book(72, Collections.singletonList(new Passenger("Elvin", "Taghizade")));
    String expected = new Booking(72, Collections.singletonList(new Passenger("Elvin", "Taghizade"))).represent();
    String actual = bookingController.getMyFlights("Elvin", "Taghizade");
    assertEquals(expected, actual);
  }

  @Test
  void cancelBooking() {
    LocalTime time = LocalTime.parse(LocalTime.now().minusHours(1)
            .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    LocalDate date = LocalDate.now().plusDays(1);
    Flight flight = new Flight(72, "Ganja", date.plusDays(100), time, 150);
    flightService.addFlight(flight);
    bookingController.book(72, Collections.singletonList(new Passenger("Elvin", "Taghizade")));
    String expected = "Booking deleted.";
    String actual = bookingController.cancelBooking(1, daoFlight);
    assertEquals(expected, actual);
  }
}