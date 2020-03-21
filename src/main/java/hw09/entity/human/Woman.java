package hw09.entity.human;

import hw09.entity.DayOfWeek;
import hw09.entity.Family;
import java.util.Map;

public final class Woman extends Human {
  public Woman() {
    super();
  }

  public Woman(String name, String surname) {
    super(name, surname);
  }

  public Woman(String name, String surname, int year) {
    super(name, surname, year);
  }

  public Woman(String name, String surname, int year, Map<DayOfWeek, String> schedule) {
    super(name, surname, year, schedule);
  }

  Woman(String name, String surname, int year, int iq, Family family, Map<DayOfWeek, String> schedule) {
    super(name, surname, year, iq, schedule, family);
  }

  ///METHODS
  public void makeUp() {
    System.out.println("Woman using makeup");
  }

  @Override
  public void greetPet() {
    System.out.println("GreetPet method inside Woman class");
  }
}