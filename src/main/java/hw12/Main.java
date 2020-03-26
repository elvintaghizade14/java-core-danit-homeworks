package hw12;

import hw12.controller.FamilyController;
import hw12.entity.Family;
import hw12.entity.human.Man;
import hw12.entity.human.Woman;
import hw12.entity.pet.Dog;
import hw12.entity.pet.DomesticCat;
import hw12.entity.pet.Pet;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws ParseException {
    ConsoleApp consoleApp = new ConsoleApp();
    consoleApp.runApplication();
  }
}
