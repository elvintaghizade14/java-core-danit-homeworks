package Step_Project_1.dao;

import Step_Project_1.entity.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOBookingFileText implements DAO<Booking> {

  private File file;

  public DAOBookingFileText(String filename) {
    this.file = new File(filename);
  }

  private void write(Collection<Booking> bookings) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
      for (Booking b : bookings) {
        bw.write(b.fileWrite());
        bw.write("\n");
      }
    } catch (IOException ex) {
      throw new RuntimeException("DAO-Booking:write:IOException", ex);
    }
  }

  @Override
  public Collection<Booking> getAll() {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      return br.lines().map(Booking::parse).collect(Collectors.toList());
    } catch (IOException ex) {
      return new ArrayList<>();
    }
  }

  @Override
  public Optional<Booking> get(int id) {
    return getAll().stream().filter(b -> b.getId() == id).findFirst();
  }

  @Override
  public Collection<Booking> getAllBy(Predicate<Booking> p) {
    return getAll().stream().filter(p).collect(Collectors.toList());
  }

  @Override
  public void create(Booking booking) {
    Collection<Booking> bookings = getAll();
    bookings.add(booking);
    write(bookings);
  }

  @Override
  public void delete(int id) {
    Collection<Booking> bookings = getAllBy(b -> b.getId() != id);
    write(bookings);
  }
}