package hw07.classes;

public class DomesticCat extends Pet {
  DomesticCat() {
    super();
  }

  DomesticCat(String nickname) {
    super(nickname);
    species = Species.DOMESTICCAT;
  }

  DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
    super(nickname, age, trickLevel, habits);
    species = Species.DOMESTICCAT;
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