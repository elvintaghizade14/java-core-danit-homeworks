package hw09.entity.human;

import hw09.entity.DayOfWeek;
import hw09.entity.Family;

import java.util.Map;

public final class Man extends Human {
  ///CONSTRUCTOR
  public Man() {
    super();
  }

  public Man(String name, String surname) {
    super(name, surname);
  }

  public Man(String name, String surname, int year) {
    super(name, surname, year);
  }

  public Man(String name, String surname, int year, int iq, Family family, Map<DayOfWeek, String> schedule) {
    super(name, surname, year, iq, schedule, family);
  }

  public Man(String name, String surname, int year, Map<DayOfWeek, String> schedule) {
    super(name, surname, year, schedule);
  }

  ///METHODS
  public void repairCar() {
    System.out.println("Car was broken. I am repairing it");
  }

  @Override
  public void greetPet() {
    System.out.println("GreetPet method inside Man class");
  }
}