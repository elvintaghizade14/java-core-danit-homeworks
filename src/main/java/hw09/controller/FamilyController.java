package hw09.controller;

import hw09.entity.Family;
import hw09.entity.human.Human;
import hw09.entity.pet.Pet;
import hw09.service.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController {

  private FamilyService familyService = new FamilyService();

  public List<Family> getAllFamilies() {
    return familyService.getAllFamilies();
  }

  public String displayAllFamilies() {
    return familyService.displayAllFamilies();
  }

  public List<Family> getFamiliesBiggerThan(int numberOfPeople) {
    return familyService.getFamiliesBiggerThan(numberOfPeople);
  }

  public List<Family> getFamiliesLessThan(int numHuman) {
    return familyService.getFamiliesLessThan(numHuman);
  }

  public int countFamiliesWithMemberNumber(int numberOfPeople) {
    return familyService.countFamiliesWithMemberNumber(numberOfPeople);
  }

  public void createNewFamily(Human mother, Human father) {
    familyService.createNewFamily(mother, father);
  }

  public void deleteFamilyByIndex(int index) {
    familyService.deleteFamilyByIndex(index);
  }

  public void deleteFamily(Family family) {
    familyService.deleteFamily(family);
  }

  public Family bornChild(Family family, String manName, String womanName) {
    return familyService.bornChild(family, manName, womanName);
  }

  public Family adoptChild(Family family, Human child) {
    return familyService.adoptChild(family, child);
  }

  public void deleteAllChildrenOlderThen(int age) {
    familyService.deleteAllChildrenOlderThen(age);
  }

  public int count() {
    return familyService.count();
  }

  public Family getFamilyById(int index) {
    return familyService.getFamilyById(index);
  }

  public Set<Pet> getPets(int index) {
    return familyService.getPets(index);
  }

  public void addPet(int familyIndex, Pet pet) {
    familyService.addPet(familyIndex, pet);
  }

  public void saveFamily(Family familyKari) {
    familyService.saveFamily(familyKari);
  }
}