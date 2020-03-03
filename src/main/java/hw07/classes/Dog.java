package hw07.classes;

public class Dog extends Pet implements Foul {
  Dog() {
    super();
  }

  Dog(String nickname) {
    super(Species.DOG, nickname);
  }

  Dog(String nickname, int age, int trickLevel, String[] habits) {
    super(Species.DOG, nickname, age, trickLevel, habits);
  }

  @Override
  public void respond() {
    System.out.println("HAV HAV HAV");
  }

  @Override
  public void foul() {
    System.out.println("Foul method in Dog class.");
  }
}
