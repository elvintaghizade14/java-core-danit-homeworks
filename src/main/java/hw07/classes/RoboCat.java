package hw07.classes;

public class RoboCat extends Pet {
  RoboCat() {
    super();
  }

  RoboCat(String nickname) {
    super(nickname);
    species = Species.ROBOCAT;

  }

  RoboCat(String nickname, int age, int trickLevel, String[] habits) {
    super(nickname, age, trickLevel, habits);
    species = Species.ROBOCAT;
  }

  @Override
  public void respond() {
    System.out.println("RoboCat sound :)");
  }

  @Override
  public void foul() {
    System.out.println("Foul of RoboCat");
  }
}