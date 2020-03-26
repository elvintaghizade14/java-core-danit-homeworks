package hw13.entity;

import hw13.entity.human.Human;
import hw13.entity.human.Man;
import hw13.entity.pet.Pet;

import java.util.*;
import java.util.stream.Collectors;

public class Family {
  private Human father;
  private Human mother;
  private List<Human> children = new ArrayList<>();
  private Set<Pet> pet = new HashSet<>();

  //CONSTRUCTORS
  public Family() {
  }

  public Family(Human mother, Human father) {
    this.mother = mother;
    this.father = father;
    mother.setFamily(this);
    father.setFamily(this);
  }

  public Family(Human father, Human mother, Pet pet) {
    this.father = father;
    this.mother = mother;
    this.pet.add(pet);
  }

  // OWN METHODS
  public void addChild(Human child) {
    if (!children.contains(child)) {
      children.add(child);
      child.setFamily(this);
    }
  }

  public boolean deleteChild(int index) {
    if (children == null || index < 0 || index >= children.size()) return false;
    else {
      children.remove(index);
      return true;
    }
  }

  public boolean deleteChild(Human child) {
    if (children.contains(child)) {
      children.remove(child);
      return true;
    }
    return false;
  }

  public int countFamily() {
    int count = 0;
    if (mother != null) count++;
    if (father != null) count++;
    if (children != null) count += children.size();
    return count;
  }

  // GETTERS - SETTERS
  public Human getMother() {
    return mother;
  }

  public void setMother(Human mother) {
    this.mother = mother;
  }

  public Human getFather() {
    return father;
  }

  public void setFather(Human father) {
    this.father = father;
  }

  public List<Human> getChildren() {
    return children;
  }

  public void setChildren(List<Human> children) {
    this.children = children;
  }

  public Set<Pet> getPet() {
    return pet;
  }

  public void setPet(Set<Pet> pet) {
    this.pet = pet;
  }

  @Override
  public String toString() {
    return String.format("Family{father=%s mother=%s children=%s Pet=%s}",
            father, mother, children.stream().map(Human::toString).collect(Collectors.toList()).toString(), pet);
  }

  public String prettyFormat() {
    return children.stream()
            .map(c -> String.format("\n\t\t%s%s", c instanceof Man ? "boy:" : "girl:", c.toString()))
            .collect(Collectors.toList()).toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Family family = (Family) o;
    return Objects.equals(getFather(), family.getFather()) &&
            Objects.equals(getMother(), family.getMother()) &&
            Objects.equals(getChildren(), family.getChildren()) &&
            Objects.equals(getPet(), family.getPet());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFather(), getMother(), getChildren(), getPet());
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("object of family class deleted");
    super.finalize();
  }
}