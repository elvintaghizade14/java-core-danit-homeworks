package Step_Project_1.service;

import Step_Project_1.dao.DAOFlightFileText;
import Step_Project_1.entity.Flight;
import Step_Project_1.entity.Passenger;
import Step_Project_1.ex.FlightCannotCreateException;
import Step_Project_1.ex.FlightNotFoundException;
import Step_Project_1.helpers.FlightGenerator;
import Step_Project_1.helpers.Predicates;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightService {
  DAOFlightFileText daoFlight;

  public FlightService(DAOFlightFileText daoFlight) {
    this.daoFlight = daoFlight;
  }

  public boolean isFlightsFileEmpty() {
    return daoFlight.getAll().size() == 0;
  }


  public String showMenu() {
    StringBuilder sb = new StringBuilder();
    return sb.append("1. Online - board\n")
            .append("2. Show the flight info\n")
            .append("3. Search and book a flight\n")
            .append("4. Cancel the booking\n")
            .append("5. My flights\n")
            .append("6. Exit")
            .toString();
  }

  public List<String> getAllFlights() {
    return daoFlight.getAllBy(Predicates.isSomeHoursBefore())
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public String getFlightById(int flightId) {
    return daoFlight.get(flightId).map(Flight::represent)
            .orElseThrow(FlightNotFoundException::new);
  }

  public List<String> searchForBook(String dest, LocalDate date, int numOfPeople) {
    return daoFlight.getAllBy(Predicates.isBookable(dest, date, numOfPeople))
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public void addFlight() {
    daoFlight.create(FlightGenerator.genFlight());
  }

  public void makeChangesForBooking(int flightId, List<Passenger> passengers) {
    Optional<Flight> updatedFlight = daoFlight.get(flightId);
    daoFlight.delete(flightId);
    updatedFlight.ifPresent(f -> f.setFreeSpaces(f.getFreeSpaces() - passengers.size()));
    daoFlight.create(updatedFlight.orElseThrow(FlightCannotCreateException::new));
  }
}