package hw07.classes;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
  protected Species species = Species.UNKNOWN;
  private String nickname;
  private int age;
  private int trickLevel;
  private String[] habits;

  // CONSTRUCTORS
  public Pet() {

  }

  public Pet(String nickname) {
    this.nickname = nickname;
  }

  public Pet(String nickname, int age, int trickLevel, String[] habits) {
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
    this.habits = habits;
  }

  // OWN METHODS
  public void eat() {
    System.out.println("I am eating.\n");
  }

  public abstract void respond();

  public abstract void foul();

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
