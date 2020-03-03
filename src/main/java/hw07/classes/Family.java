package hw07.classes;

import java.util.Arrays;
import java.util.Objects;

public class Family {
  private Human father;
  private Human mother;
  private Human[] children;
  private Pet pet;

  //CONSTRUCTORS
  public Family() {
  }

  public Family(Human mother, Human father) {
    this.mother = mother;
    this.father = father;
    mother.setFamily(this);
    father.setFamily(this);
    this.children = new Human[0];
  }

  public Family(Human father, Human mother, Pet pet) {
    this.father = father;
    this.mother = mother;
    this.pet = pet;
  }

  // OWN METHODS
  public void addChild(Human child) {
    if (children != null) {
      int indx = children.length;
      children = Arrays.copyOf(children, indx + 1);
      children[indx] = child;
      this.setChildren(children);
    } else {
      Human[] children = new Human[1];
      children[0] = child;
      this.setChildren(children);
    }
    child.setFamily(this);
  }

  public boolean deleteChild(int indx) {
    if (children == null || indx < 0 || indx >= children.length) return false;
    else {
      int newArrLen = children.length - 1;
      Human[] updatedChildrenArray = new Human[newArrLen];
      for (int i = 0, j = 0; i < newArrLen; i++) {
        if (i != indx) updatedChildrenArray[j++] = children[i];
      }
      this.setChildren(updatedChildrenArray);
      return true;
    }
  }

  public boolean deleteChild(Human child) {
    for (int indx = 0; indx < children.length; indx++) {
      if (children[indx].equals(child)) {
        if (this.deleteChild(indx)) {
          return true;
        }
      }
    }
    return false;
  }

  public int countFamily() {
    int countMother = 0;
    int countFather = 0;
    int countChildren = 0;
    if (mother != null) {
      countMother = 1;
    }
    if (father != null) {
      countFather = 1;
    }
    if (children != null) {
      countChildren = children.length;
    }
    return countMother + countFather + countChildren;
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

  public Human[] getChildren() {
    return children;
  }

  public void setChildren(Human[] children) {
    this.children = children;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  @Override
  public String toString() {
    return String.format("Family{father='%s',\nmother='%s',\nchildren='%s',\nPet='%s'}",
            father, mother, Arrays.toString(children), pet);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Family family = (Family) o;
    return Objects.equals(getFather(), family.getFather()) &&
            Objects.equals(getMother(), family.getMother()) &&
            Arrays.equals(getChildren(), family.getChildren()) &&
            Objects.equals(getPet(), family.getPet());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getFather(), getMother(), getPet());
    result = 31 * result + Arrays.hashCode(getChildren());
    return result;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("object of family class deleted");
    super.finalize();
  }
}