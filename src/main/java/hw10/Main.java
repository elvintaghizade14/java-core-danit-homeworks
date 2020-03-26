package hw10;

import hw10.controller.FamilyController;
import hw10.entity.Family;
import hw10.entity.human.Man;
import hw10.entity.human.Woman;
import hw10.entity.pet.Dog;
import hw10.entity.pet.DomesticCat;
import hw10.entity.pet.Pet;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws ParseException {
    Pet dog = new Dog("Jim");
    dog.setAge(15);
    dog.setTrickLevel(25);
    Set<String> habitsOfDog = new HashSet<>();
    habitsOfDog.add("sleep");
    habitsOfDog.add("eat");
    habitsOfDog.add("code");
    dog.setHabits(habitsOfDog);

    Pet cat = new DomesticCat("Tom");
    cat.setAge(3);
    cat.setTrickLevel(80);
    Set<String> habitsOfCat = new HashSet<>();
    habitsOfCat.add("run");
    habitsOfCat.add("play");
    habitsOfCat.add("sleep");
    cat.setHabits(habitsOfCat);

    // Kari family
    Woman motherKari = new Woman("Maria", "Kari", "1976/03/25");
    motherKari.setIq(65);
    Man fatherKari = new Man("Pier", "Kari", "1970/04/02");
    fatherKari.setIq(75);
    Family familyKari = new Family(fatherKari, motherKari);

    // Imeno family
    Man fatherImeno = new Man("Peter", "Imeno", "1981/02/10");
    fatherImeno.setIq(75);
    Woman motherImeno = new Woman("Kate", "Imeno", "1983/01/20");
    motherImeno.setIq(65);
    Family familyImeno = new Family(fatherImeno, motherImeno);

    //family Watson
    Man fatherWatson = new Man("John", "Watson", "1980/05/12");
    fatherWatson.setIq(75);
    Woman motherWatson = new Woman("Dila", "Watson", "1985/06/14");
    motherWatson.setIq(65);
    Family familyWatson = new Family(fatherWatson, motherWatson);

    FamilyController familyController = new FamilyController();

    Man man1 = new Man("1111", "1111", "1999/01/01");
    Man man2 = new Man("2222", "2222", "1998/02/02");
    Man man3 = new Man("3333", "3333", "1997/03/03");
    Man man4 = new Man("4444", "4444", "1996/04/04");
    Man man5 = new Man("5555", "5555", "1995/05/05");
    Man man6 = new Man("6666", "6666", "2008/06/19");
    Man man7 = new Man("7777", "7777", "2005/10/22");
    Man man8 = new Man("8888", "8888", "2010/12/29");

    Man man = new Man("AAA", "BBB", "2000/07/18");
    Woman woman = new Woman("DDD", "FFF", "2001/09/15");
    familyController.createNewFamily(man,woman);

    familyController.adoptChild(familyKari, man1);
    familyController.adoptChild(familyKari, man4);
    familyController.bornChild(familyKari, null, "Jane");

    familyController.adoptChild(familyImeno, man2);
    familyController.adoptChild(familyImeno, man6);
    familyController.adoptChild(familyImeno, man7);

    familyController.adoptChild(familyWatson, man3);
    familyController.adoptChild(familyWatson, man5);
    familyController.bornChild(familyWatson, "Jack", null);

    familyController.saveFamily(familyKari);
    familyController.saveFamily(familyImeno);
    familyController.saveFamily(familyWatson);

    familyController.addPet(2, dog);
    familyController.addPet(3, cat);

    System.out.println(man5.describeAge());
    familyController.getAllFamilies();
    System.out.println(familyController.displayAllFamilies());
    familyController.count();
    familyController.getFamiliesBiggerThan(2);
    familyController.getFamiliesLessThan(5);
    familyController.countFamiliesWithMemberNumber(4);
    familyController.deleteFamilyByIndex(1);
    familyController.deleteFamily(familyKari);
    familyController.deleteAllChildrenOlderThen(17);
    familyController.displayAllFamilies();
    familyController.getPets(1);
    familyController.getFamilyById(1);
  }
}
