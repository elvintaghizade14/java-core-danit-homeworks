package hw09.entity.pet;

import java.util.Set;

public class Fish extends Pet {
  Fish() {
    super();
  }

  Fish(String nickname) {
    super(nickname);
    species = Species.FISH;
  }

  Fish(String nickname, int age, int trickLevel, Set<String> habits) {
    super(nickname, age, trickLevel, habits);
    species = Species.FISH;
  }

  @Override
  public void respond() {
    System.out.printf("Fish sound ;) i am %s\n", getNickname());
  }

  @Override
  public void foul() {
    System.out.println("Foul of fish...");
  }
}