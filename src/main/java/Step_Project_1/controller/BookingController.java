package Step_Project_1.controller;

import Step_Project_1.dao.DAOFlightFileText;
import Step_Project_1.entity.Passenger;
import Step_Project_1.ex.FlightNotFoundException;
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

  // menu - 3.2 - booking - found flight above
  public void book(int flightId, List<Passenger> passengers) {
    bookingService.book(flightId, passengers);
  }

  // menu - 5 - show all flights by passenger's info
  public String getMyFlights() {
    console.print("Enter name: ");
    String name = console.readLn();
    console.print("Enter surname: ");
    String surname = console.readLn();
    try {
      return String.join("\n",
              bookingService.getMyFlights(name.toLowerCase().trim(),
                      surname.toLowerCase().trim()));
    } catch (FlightNotFoundException ex) {
      return "Smth went wrong and flight not found";
    }
  }

  public String cancelBooking(int bookingId, DAOFlightFileText daoFlight) {
    return bookingService.cancelBooking(bookingId, daoFlight);
  }
}
