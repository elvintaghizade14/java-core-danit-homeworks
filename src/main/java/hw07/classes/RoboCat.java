package hw07.classes;

public class RoboCat extends Pet {
  RoboCat() {
    super();
  }

  RoboCat(String nickname) {
    super(Species.ROBOCAT, nickname);
  }

  RoboCat(String nickname, int age, int trickLevel, String[] habits) {
    super(Species.ROBOCAT, nickname, age, trickLevel, habits);
  }

  @Override
  public void respond() {
    System.out.println("RoboCat sound :)");
  }
}