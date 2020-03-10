package hw08.classes;

import java.util.Map;

public final class Woman extends Human {
  Woman() {
    super();
  }

  Woman(String name, String surname, int year) {
    super(name, surname, year);
  }

  Woman(String name, String surname, int year, Map<DayOfWeek, String> schedule) {
    super(name, surname, year, schedule);
  }

  Woman(String name, String surname, int year, int iq, Family family, Map<DayOfWeek, String> schedule) {
    super(name, surname, year, iq, schedule, family);
  }

  ///METHODS
  public void makeUp() {
    System.out.println("Bez kraska)))");
  }

  @Override
  public void greetPet() {
    System.out.printf("Hello, %s\n", getFamily().getPet().toString());
  }
}