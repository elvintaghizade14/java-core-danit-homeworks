package Step_Project_1.entity;

import Step_Project_1.dao.DAOFlightFileText;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Objects;

public class Flight {
  private int id;
  private String dest;
  private LocalDate date;
  private LocalTime time;
  private int freeSpaces;

  public Flight(String dest, LocalDate date, LocalTime time, int freeSpaces) {
    int lastFlightId = new DAOFlightFileText("flights.txt")
            .getAll().stream().max(Comparator.comparingInt(f -> f.id))
            .map(f -> f.id).orElse(0);
    this.id = ++lastFlightId;
    this.dest = dest;
    this.date = date;
    this.time = time;
    this.freeSpaces = freeSpaces;
  }

  public Flight(int flightId, String dest, LocalDate date, LocalTime time, int freeSpaces) {
    this.id = flightId;
    this.dest = dest;
    this.date = date;
    this.time = time;
    this.freeSpaces = freeSpaces;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDest() {
    return dest;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

  public int getFreeSpaces() {
    return freeSpaces;
  }

  public void setDest(String dest) {
    this.dest = dest;
  }

  public void setFreeSpaces(int freeSpaces) {
    this.freeSpaces = freeSpaces;
  }

  public String represent() {
    return String.format("%d|%s|%s|%s|%d", id, dest, date, time, freeSpaces);
  }

  public static Flight parse(String line) {
    String[] chunks = line.split("\\|");
    return new Flight(Integer.parseInt(chunks[0]), chunks[1], LocalDate.parse(chunks[2]),
            LocalTime.parse(chunks[3]), Integer.parseInt(chunks[4])
    );
  }

  public static Integer getLastFlightId() {
    DAOFlightFileText daoFlightFile = new DAOFlightFileText("flights.txt");
    return daoFlightFile.getAll().stream().max(Comparator.comparingInt(f -> f.id)).map(f -> f.id).orElse(0);
  }

  @Override
  public String toString() {
    return String.format("Flight{id=%d, dest='%s', date=%s, time=%s, freeSpaces=%d}", id, dest, date, time, freeSpaces);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Flight flight = (Flight) o;
    return id == flight.id &&
            freeSpaces == flight.freeSpaces &&
            Objects.equals(dest, flight.dest) &&
            Objects.equals(date, flight.date) &&
            Objects.equals(time, flight.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dest, date, time, freeSpaces);
  }
}
