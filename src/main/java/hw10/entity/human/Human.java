package hw10.entity.human;

import hw10.entity.DayOfWeek;
import hw10.entity.Family;
import hw10.entity.pet.Pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Human {
  private String name;
  private String surname;
  private long birthDay;
  private int iq;
  private Family family;
  private Map<DayOfWeek, String> schedule = new HashMap<>();
  private final SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

  // CONSTRUCTORS
  public Human() {
  }

  public Human(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public Human(String name, String surname, String birthDay) throws ParseException {
    this(name, surname);
    this.birthDay = formatDate.parse(birthDay).getTime();
  }

  public Human(String name, String surname, String birthDay, Map<DayOfWeek, String> schedule) throws ParseException {
    this(name, surname, birthDay);
    this.schedule = schedule;
  }

  public Human(String name, String surname, String birthDay, int iq, Map<DayOfWeek, String> schedule, Family family) throws ParseException {
    this(name, surname, birthDay, schedule);
    this.iq = iq;
    this.family = family;
  }

  // constructor for adopted child
  public Human(String name, String surname, String birthDay, int iq) throws ParseException {
    this(name, surname, birthDay);
    this.iq = iq;
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

  public String describeAge() {
    Date birthDate = new Date(birthDay);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(birthDate);
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int days = calendar.get(Calendar.DAY_OF_MONTH);
    LocalDate localDate = LocalDate.of(year, month, days);
    LocalDate now = LocalDate.now();
    Period period = Period.between(localDate, now);
    return String.format("Years: %d\nMonths: %d\nDays: %d",
            period.getYears(), period.getMonths(), period.getDays());
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

  public long getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(int birthDay) {
    this.birthDay = birthDay;
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
    return String.format("Human[name='%s', surname='%s', birthDay=%s, iq=%d, schedule=%s]\n",
            name, surname, formatDate.format(birthDay), iq, schedule.toString());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Human human = (Human) o;
    return getBirthDay() == human.getBirthDay() &&
            getIq() == human.getIq() &&
            Objects.equals(getName(), human.getName()) &&
            Objects.equals(getSurname(), human.getSurname()) &&
            Objects.equals(getFamily(), human.getFamily()) &&
            Objects.equals(getSchedule(), human.getSchedule());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getSurname(), getBirthDay(), getIq(), getFamily(), getSchedule());
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Object of Human class deleted");
    super.finalize();
  }
}