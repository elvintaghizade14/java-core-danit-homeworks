package Step_Project_1.dao;

import Step_Project_1.entity.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOFlightFileText implements DAO<Flight> {
  private File file;

  public DAOFlightFileText(String filename) {
    this.file = new File(filename);
  }

  private void write(Collection<Flight> flights) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
      for (Flight f : flights) {
        bw.write(f.represent());
        bw.write("\n");
      }
    } catch (IOException ex) {
      throw new RuntimeException("DAO-Flight:write:IOException", ex);
    }
  }

  @Override
  public Optional<Flight> get(int id) {
    return getAll().stream().filter(f -> f.getId() == id).findFirst();
  }

  @Override
  public Collection<Flight> getAll() {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      return br.lines().map(Flight::parse).collect(Collectors.toList());
    } catch (IOException ex) {
      return new ArrayList<>();
    }
  }

  @Override
  public Collection<Flight> getAllBy(Predicate<Flight> p) {
    return getAll().stream().filter(p).collect(Collectors.toList());
  }

  @Override
  public void create(Flight flight) {
    Collection<Flight> flights = getAll();
    flights.add(flight);
    write(flights);
  }

  @Override
  public void delete(int id) {
    Collection<Flight> flights = getAllBy(f -> f.getId() != id);
    write(flights);
  }
}
