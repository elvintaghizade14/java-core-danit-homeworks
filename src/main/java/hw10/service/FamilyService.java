package hw10.service;

import hw10.dao.CollectionFamilyDao;
import hw10.entity.Family;
import hw10.entity.human.Human;
import hw10.entity.human.Man;
import hw10.entity.human.Woman;
import hw10.entity.pet.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FamilyService {

  private CollectionFamilyDao familyDao = new CollectionFamilyDao();

  public List<Family> getAllFamilies() {
    return (List<Family>) familyDao.getAllFamilies();
  }

  public List<Family> displayAllFamilies() {
    return (List<Family>) familyDao.getAllFamilies();
  }

  public List<Family> getFamiliesBiggerThan(int numberOfPeople) {
    return new ArrayList<>(familyDao.getAllFamiliesBy(f -> f.countFamily() > numberOfPeople));
  }

  public List<Family> getFamiliesLessThan(int numberOfPeople) {
    return new ArrayList<>(familyDao.getAllFamiliesBy(f -> f.countFamily() < numberOfPeople));
  }

  public int countFamiliesWithMemberNumber(int numberOfPeople) {
    return familyDao.getAllFamiliesBy(f -> f.countFamily() == numberOfPeople).size();
  }

  public void createNewFamily(Human mother, Human father) {
    familyDao.saveFamily(new Family(mother, father));
  }

  public void deleteFamilyByIndex(int index) {
    familyDao.deleteFamily(index);
  }

  public void deleteFamily(Family family) {
    familyDao.deleteFamily(family);
  }

  public Family bornChild(Family family, String manName, String womanName) {
    if (manName != null) {
      Human son = new Man(manName, family.getFather().getSurname());
      family.addChild(son);
    } else if (womanName != null) {
      Woman daughter = new Woman(womanName, family.getFather().getSurname());
      family.addChild(daughter);
    } else return null;
    return family;
  }

  public Family adoptChild(Family family, Human child) {
    child.setSurname(family.getFather().getSurname());
    family.addChild(child);
    return family;
  }

  public void deleteAllChildrenOlderThen(int age) {
    List<Family> families = (List<Family>) familyDao.getAllFamilies();
    for (Family family : families) {
      family.getChildren().removeIf(child -> 2020 - child.getBirthDay() > age);
    }
  }

  public int count() {
    return familyDao.getAllFamilies().size();
  }

  public Family getFamilyById(int index) {
    return familyDao.getFamilyByIndex(index);
  }

  public Set<Pet> getPets(int index) {
    return familyDao.getFamilyByIndex(index).getPet();
  }

  public void addPet(int familyIndex, Pet pet) {
    familyDao.getFamilyByIndex(familyIndex).getPet().add(pet);
  }

  public void saveFamily(Family familyKari) {
    familyDao.saveFamily(familyKari);
  }
}