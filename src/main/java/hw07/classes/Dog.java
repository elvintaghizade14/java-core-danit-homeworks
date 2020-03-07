package hw07.classes;

public class Dog extends Pet {
  Dog() {
    super();
  }

  Dog(String nickname) {
    super(nickname);
    species = Species.DOG;
  }

  Dog(String nickname, int age, int trickLevel, String[] habits) {
    super(nickname, age, trickLevel, habits);
    species = Species.DOG;
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
