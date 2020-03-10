package hw07.classes;

public final class Woman extends Human {
  Woman() {
    super();
  }

  Woman(String name, String surname, int year) {
    super(name, surname, year);
  }

  Woman(String name, String surname, int year, int iq, Family family, String[][] schedule) {
    super(name, surname, year, iq, schedule, family);
  }

  public Woman(String name, String surname, int year, String[][] schedule) {
    super(name, surname, year, schedule);
  }

  ///METHODS
  public void makeUp() {
    System.out.println("Bez kraska)))");
  }

  @Override
  public void greetPet() {
    System.out.printf("Hello, %s\n", getFamily().getPet().getNickname());
  }
}