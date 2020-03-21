package hw09.entity.human;

import hw09.entity.DayOfWeek;
import hw09.entity.Family;
import hw09.entity.pet.Pet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
    this(name, surname);
    this.year = year;
  }

  public Human(String name, String surname, int year, Map<DayOfWeek, String> schedule) {
    this(name, surname, year);
    this.schedule = schedule;
  }

  public Human(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule, Family family) {
    this(name, surname, year, schedule);
    this.iq = iq;
    this.family = family;
  }

  public Human(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  // OWN METHODS
  public void greetPet() {
    System.out.printf("Hello, %s", family.getPet()
            .stream().map(Pet::getNickname).collect(Collectors.toList()).toString());
  }

  public void describePet() {
    if (family == null || family.getPet() == null) System.out.println("There is no any pets.");
    else {
      for (Pet pets : family.getPet()) {
        System.out.printf("I have a %s, he is %d years old, he is %s.\n",
                pets.getSpecies(), pets.getAge(), pets.getTrickLevel() > 49 ? "very sly" : "almost not sly");
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
    return String.format("Human[name='%s', surname='%s', year=%d, iq=%d, schedule=%s]\n",
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