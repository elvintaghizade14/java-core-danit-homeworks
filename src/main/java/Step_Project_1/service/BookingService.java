package Step_Project_1.service;

import Step_Project_1.dao.DAOBookingFileText;
import Step_Project_1.dao.DAOFlightFileText;
import Step_Project_1.entity.Booking;
import Step_Project_1.entity.Flight;
import Step_Project_1.entity.Passenger;
import Step_Project_1.ex.BookingNotFoundException;
import Step_Project_1.ex.FlightNotFoundException;
import Step_Project_1.helpers.Predicates;

import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
  DAOBookingFileText daoBooking;

  public BookingService(DAOBookingFileText daoBooking) {
    this.daoBooking = daoBooking;
  }

  public void book(int flightId, List<Passenger> passengers) {
    daoBooking.create(new Booking(flightId, passengers));
  }

  public List<String> getMyFlights(String name, String surname) {
    List<String> result = daoBooking.getAllBy(Predicates.isMyFlight(name, surname))
            .stream().map(Booking::represent).collect(Collectors.toList());
    if (result.size() == 0) throw new FlightNotFoundException();
    else return result;
  }

  public String cancelBooking(int bookingId, DAOFlightFileText daoFlight) {
    return daoBooking.get(bookingId).map(b -> {
      Flight newFlight = daoFlight.get(b.getFlight_id()).orElseThrow(RuntimeException::new);
      newFlight.setFreeSpaces(newFlight.getFreeSpaces() + b.getPassengers().size());
      daoBooking.delete(bookingId);
      daoFlight.delete(b.getFlight_id());
      daoFlight.create(newFlight);
      return "Booking deleted.";
    }).orElseThrow(BookingNotFoundException::new);
  }
}
