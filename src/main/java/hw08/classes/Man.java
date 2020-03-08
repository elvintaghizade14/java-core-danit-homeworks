package hw08.classes;

import java.util.Map;

public final class Man extends Human {
  ///CONSTRUCTOR
  Man() {
    super();
  }

  Man(String name, String surname, int year) {
    super(name, surname, year);
  }

  Man(String name, String surname, int year, int iq, Family family, Map<DayOfWeek, String> schedule) {
    super(name, surname, year, iq, schedule, family);
  }

  public Man(String name, String surname, int year, Map<DayOfWeek, String> schedule) {
    super(name, surname, year, schedule);
  }

  ///METHODS
  public void repairCar() {
    System.out.println("Car was broken. I am reparing(((");
  }

  @Override
  public void greetPet() {
    System.out.println("Hello");
  }
}