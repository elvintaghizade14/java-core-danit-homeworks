package Step_Project_1.entity;

import Step_Project_1.dao.DAOBookingFileText;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Booking {
  private int id;
  private int flight_id;
  private List<Passenger> passengers;

  public static int counter = 0;

  public Booking(int flight_id, List<Passenger> passengers) {
    int lastBookingId = new DAOBookingFileText("bookings.txt").getAll().stream()
            .max(Comparator.comparingInt(b -> b.id)).map(b -> b.id).orElse(0);
    this.id = ++lastBookingId;
    this.flight_id = flight_id;
    this.passengers = passengers;
  }

  public Booking(int id, int flight_id, List<Passenger> passengers) {
    this.id = id;
    this.flight_id = flight_id;
    this.passengers = passengers;
  }

  public int getId() {
    return id;
  }

  public void setFlight_id(int flight_id) {
    this.flight_id = flight_id;
  }

  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getFlight_id() {
    return flight_id;
  }

  public List<Passenger> getPassengers() {
    return this.passengers;
  }

  public String represent() {
    return String.format("%d/%d/%s",
            id, flight_id, passengers.stream().map(Passenger::represent).collect(Collectors.toList()));
  }

  public static Booking parse(String line) {
    String[] chunks = line.split("/");
    return new Booking(Integer.parseInt(chunks[0]), Integer.parseInt(chunks[1]),
            Arrays.stream(chunks[2].split(", "))
                    .map(s -> new Passenger(s.split("::")[0],
                            s.split("::")[1])).collect(Collectors.toList()));
  }

  public String fileWrite() {
    String passenger = passengers.stream().map(Passenger::represent).collect(Collectors.toList()).toString();
    return String.format("%d/%d/%s", id, flight_id,
            passenger.substring(1, passenger.length() - 1));
  }
}
