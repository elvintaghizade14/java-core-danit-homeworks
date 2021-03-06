package hw08.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
  private String name;
  private String surname;
  private int year;
  private int iq;
  private Family family;
  private Map<DayOfWeek, String> schedule = new HashMap<>();

  // CONSTRUCTORS
  public Human() {
  }

  public Human(String name, String surname, int year) {
    this.name = name;
    this.surname = surname;
    this.year = year;
  }

  public Human(String name, String surname, int year, Map<DayOfWeek, String> schedule) {
    this.name = name;
    this.surname = surname;
    this.year = year;
    this.schedule = schedule;
  }

  public Human(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule, Family family) {
    this.name = name;
    this.surname = surname;
    this.year = year;
    this.iq = iq;
    this.schedule = schedule;
    this.family = family;
  }

  // OWN METHODS
  public void greetPet() {
    System.out.printf("Hello, %s", family.getPet().toString());
  }

  public void describePet() {
    if (family == null || family.getPet() == null) System.out.println("There is no any pets.");
    else {
      for (Pet pets : family.getPet()) {
        System.out.printf("I have a %s, he is %d years old, he is %s.\n",
                pets.species, pets.getAge(), pets.getTrickLevel() > 50 ? "very sly" : "almost not sly");
      }
    }
  }

  //GETTERS - SETTERS
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getIq() {
    return iq;
  }

  public void setIq(int iq) {
    this.iq = iq;
  }

  public Map<DayOfWeek, String> getSchedule() {
    return schedule;
  }

  public void setSchedule(Map<DayOfWeek, String> schedule) {
    this.schedule = schedule;
  }

  public Family getFamily() {
    return family;
  }

  public void setFamily(Family family) {
    this.family = family;
  }

  @Override
  public String toString() {
    return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, schedule=%s}",
            name, surname, year, iq, schedule.toString());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Human human = (Human) o;
    return getYear() == human.getYear() &&
            getIq() == human.getIq() &&
            Objects.equals(getName(), human.getName()) &&
            Objects.equals(getSurname(), human.getSurname()) &&
            Objects.equals(getFamily(), human.getFamily()) &&
            Objects.equals(getSchedule(), human.getSchedule());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getSurname(), getYear(), getIq(), getFamily(), getSchedule());
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Object of Human class deleted");
    super.finalize();
  }
}