package Step_Project_1.controller;

import Step_Project_1.dao.DAOFlightFileText;
import Step_Project_1.entity.Passenger;
import Step_Project_1.io.Console;
import Step_Project_1.service.BookingService;

import java.util.List;

public class BookingController {
  private final Console console;
  private final BookingService bookingService;

  public BookingController(Console console, BookingService bookingService) {
    this.console = console;
    this.bookingService = bookingService;
  }

  public void book(int flightId, List<Passenger> passengers) {
    bookingService.book(flightId, passengers);
  }

  public String getMyFlights(String name, String surname) {
    return String.join("\n",
            bookingService.getMyFlights(name.toLowerCase().trim(), surname.toLowerCase().trim()));
  }

  public String cancelBooking(int bookingId, DAOFlightFileText daoFlight) {
    return bookingService.cancelBooking(bookingId, daoFlight);
  }
}
