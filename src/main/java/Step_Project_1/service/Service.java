package Step_Project_1.service;

import Step_Project_1.dao.DAOBookingFileText;
import Step_Project_1.dao.DAOFlightFileText;
import Step_Project_1.entity.Flight;
import Step_Project_1.ex.BookingNotFoundException;

public class Service {
  DAOBookingFileText daoBooking;
  DAOFlightFileText daoFlight;

  public Service(DAOBookingFileText daoBooking, DAOFlightFileText daoFlight) {
    this.daoBooking = daoBooking;
    this.daoFlight = daoFlight;
  }

  public String cancelBooking(int bookingId) {
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
