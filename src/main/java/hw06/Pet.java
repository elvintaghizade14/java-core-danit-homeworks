package hw06;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
  private Species species;
  private String nickname;
  private int age;
  private int trickLevel;
  private String[] habits;

  // CONSTRUCTORS
  public Pet() {

  }

  public Pet(Species species, String nickname) {
    this.species = species;
    this.nickname = nickname;
  }

  public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
    this.species = species;
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
    this.habits = habits;
  }

  // OWN METHODS
  public void eat() {
    System.out.println("I am eating.\n");
  }

  public void respond() {
    System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
  }

  public void foul() {
    System.out.println("I need to cover it up.\n");
  }

  // GETTER - SETTERS
  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getTrickLevel() {
    return trickLevel;
  }

  public void setTrickLevel(int trickLevel) {
    this.trickLevel = trickLevel;
  }

  public String[] getHabits() {
    return habits;
  }

  public void setHabits(String[] habits) {
    this.habits = habits;
  }

  @Override
  public String toString() {
    return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}",
            species, nickname, age, trickLevel, Arrays.toString(habits));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pet pet = (Pet) o;
    return getAge() == pet.getAge() &&
            getTrickLevel() == pet.getTrickLevel() &&
            Objects.equals(getSpecies(), pet.getSpecies()) &&
            Objects.equals(getNickname(), pet.getNickname()) &&
            Arrays.equals(getHabits(), pet.getHabits());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getSpecies(), getNickname(), getAge(), getTrickLevel());
    result = 31 * result + Arrays.hashCode(getHabits());
    return result;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Object of Pet class deleted");
    super.finalize();
  }
}