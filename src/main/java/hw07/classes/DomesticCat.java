package hw07.classes;

public class DomesticCat extends Pet implements Foul {
  DomesticCat() {
    super();
  }

  DomesticCat(String nickname) {
    super(Species.DOMESTICCAT, nickname);
  }

  DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
    super(Species.DOMESTICCAT, nickname, age, trickLevel, habits);
  }

  @Override
  public void respond() {
    System.out.println("Myau Myau Myau :)");
  }

  @Override
  public void foul() {
    System.out.println("Foul method in DomesticCat class");
  }
}