package Step_Project_1;

import Step_Project_1.controller.BookingController;
import Step_Project_1.controller.FlightController;
import Step_Project_1.dao.DAOBookingFileText;
import Step_Project_1.dao.DAOFlightFileText;
import Step_Project_1.entity.Passenger;
import Step_Project_1.ex.BookingNotFoundException;
import Step_Project_1.ex.FlightCannotCreateException;
import Step_Project_1.ex.FlightNotFoundException;
import Step_Project_1.io.ConsoleMain;
import Step_Project_1.service.BookingService;
import Step_Project_1.service.FlightService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
  public static void main(String[] args) {

    ConsoleMain console = new ConsoleMain();

    DAOBookingFileText daoBooking = new DAOBookingFileText("bookings.txt");
    DAOFlightFileText daoFlight = new DAOFlightFileText("flights.txt");

    BookingService bookingService = new BookingService(daoBooking);
    FlightService flightService = new FlightService(daoFlight);

    BookingController bookingController = new BookingController(console, bookingService);
    FlightController flightController = new FlightController(console, flightService);

    if (flightController.isFlightsFileEmpty()) {
      int i = 0;
      while (i++ < 30) flightController.addFlight();
    }

    boolean flag = true;
    while (flag) {
      console.printLn(flightController.showMenu());
      console.print("Enter menu num: \n");
      String input = console.readLn();
      switch (input) {
        case "1":
          console.printLn(flightController.showAllFlights());
          break;
        case "2":
          console.printLn(flightController.getFlightById());
          break;
        case "3":
          LocalDate date = null;
          int numOfPeople = 0;
          boolean notValid = true;

          console.printLn("Enter destination: ");
          String dest = console.readLn();
          while (notValid) {
            try {
              console.printLn("Enter date (YYYY-MM-DD): ");
              date = LocalDate.parse(console.readLn());
              notValid = false;
            } catch (DateTimeParseException ex) {
              console.printLn("You entered wrong value!");
              notValid = true;
            }
          }
          notValid = true;
          while (notValid) {
            try {
              console.printLn("Enter number of people: ");
              numOfPeople = Integer.parseInt(console.readLn());
              notValid = false;
            } catch (NumberFormatException ex) {
              console.printLn("You entered non-integer value!");
              notValid = true;
            }
          }
          try {
            console.printLn(flightController.searchForBook(dest, date, numOfPeople));
            int flightIdOrExit = 0;
            try {
              console.printLn("Enter flightId to book or 0 to exit: ");
              flightIdOrExit = Integer.parseInt(console.readLn());
            } catch (NumberFormatException ex) {
              console.printLn("You entered non integer value!");
            }
            if (flightIdOrExit == 0) break;
            else {
              try {
                List<Passenger> passengers = new ArrayList<>();
                while (numOfPeople-- > 0) {
                  console.print("Enter name: ");
                  String name = console.readLn();
                  console.print("Enter surname: ");
                  String surname = console.readLn();
                  passengers.add(new Passenger(name, surname));
                }
                bookingController.book(flightIdOrExit, passengers);
                flightController.makeChangesForBooking(flightIdOrExit, passengers);
                console.printLn("Booking done.");
              } catch (FlightCannotCreateException ex) {
                console.printLn("Oops, there was an error while making booking...");
              }
            }
            break;
          } catch (FlightNotFoundException ex) {
            console.printLn("There is no flight for the specified conditions");
            break;
          }
        case "4":
          try {
            console.print("Enter booking id: ");
            int bookingId = Integer.parseInt(console.readLn());
            console.printLn(bookingController.cancelBooking(bookingId, daoFlight));
          } catch (NumberFormatException ex) {
            console.printLn("You entered non-integer value!");
          } catch (BookingNotFoundException ex) {
            console.printLn("Booking not found");
          }
          break;
        case "5":
          console.printLn(bookingController.getMyFlights());
          break;
        case "6":
          flag = false;
          console.printLn("Good bye...");
          break;
        default:
          console.printLn("You've entered wrong value");
      }
    }
  }
}
