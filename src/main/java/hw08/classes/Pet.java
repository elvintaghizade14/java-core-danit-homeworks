package hw08.classes;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pet {
  protected Species species = Species.UNKNOWN;
  private String nickname;
  private int age;
  private int trickLevel;
  private Set<String> habits = new HashSet<>();

  // CONSTRUCTORS
  public Pet() {

  }

  public Pet(String nickname) {
    this.nickname = nickname;
  }

  public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
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

  public Set<String> getHabits() {
    return habits;
  }

  public void setHabits(Set<String> habits) {
    this.habits = habits;
  }

  @Override
  public String toString() {
    return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}",
            species, nickname, age, trickLevel, habits.toString());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pet pet = (Pet) o;
    return getAge() == pet.getAge() &&
            getTrickLevel() == pet.getTrickLevel() &&
            getSpecies() == pet.getSpecies() &&
            Objects.equals(getNickname(), pet.getNickname()) &&
            Objects.equals(getHabits(), pet.getHabits());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSpecies(), getNickname(), getAge(), getTrickLevel(), getHabits());
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Object of Pet class deleted");
    super.finalize();
  }
}
