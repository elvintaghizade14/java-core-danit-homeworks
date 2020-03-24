package Step_Project_1.helpers;

import Step_Project_1.entity.Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FlightGenerator {
  static Random gen = new Random();

  public static String cityGen() {
    List<String> cities = Arrays.asList("Baku", "Moscow", "Ankara", "Tbilisi", "Berlin", "NEW_YORK", "DUBAI");
    return cities.get(gen.nextInt(cities.size()));
  }

  public static LocalDate genDate() {
    LocalDate start = LocalDate.now();
    long days = ChronoUnit.DAYS.between(start, LocalDate.of(2020, Month.MARCH, 30));
    return start.plusDays(gen.nextInt((int) days + 1));
  }

  public static LocalTime genTime() {
    LocalTime time1 = LocalTime.of(8, 0);
    LocalTime time2 = LocalTime.of(15, 0);
    int secondOfDayTime1 = time1.toSecondOfDay();
    int secondOfDayTime2 = time2.toSecondOfDay();
    Random random = new Random();
    int randomSecondOfDay = secondOfDayTime1 + random.nextInt(secondOfDayTime2 - secondOfDayTime1 + 1);
    return LocalTime.ofSecondOfDay(randomSecondOfDay);
  }

  public static Flight genFlight() {
    return new Flight(cityGen(), genDate(), genTime(),
            gen.nextInt(10) * 10 + 5);
  }
}