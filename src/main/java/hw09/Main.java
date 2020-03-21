package hw09;

import hw09.entity.DayOfWeek;
import hw09.entity.Family;
import hw09.entity.human.Human;
import hw09.entity.human.Man;
import hw09.entity.human.Woman;
import hw09.entity.pet.DomesticCat;
import hw09.entity.pet.Pet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Set<String> habits = new HashSet<>();
    habits.add("coffee");
    habits.add("code");
    habits.add("sleeping");
    habits.add("Pet is a programmer :)");

    Map<DayOfWeek, String> schedule = new HashMap<>();
    schedule.put(DayOfWeek.MONDAY,"TASK_1");
    schedule.put(DayOfWeek.TUESDAY,"TASK_2");
    schedule.put(DayOfWeek.WEDNESDAY,"TASK_3");
    schedule.put(DayOfWeek.THURSDAY,"TASK_4");
    schedule.put(DayOfWeek.FRIDAY,"TASK_5");
    schedule.put(DayOfWeek.SATURDAY,"TASK_6");
    schedule.put(DayOfWeek.SUNDAY,"TASK_7");


    Man father = new Man("Father", "FATHERSURNAME", 1970, schedule);
    father.repairCar();
    father.greetPet();
    Woman mother = new Woman("Mother", "MOTHERSURNAME", 1975, schedule);
    mother.makeUp();
    mother.greetPet();
    Human son = new Human("son", "SONSURNAME", 1995, schedule);
    Human daughter = new Human("Daughter", "DAUGHTERSURNAME", 1999, schedule);
    Pet tom = new DomesticCat("TOM", 3, 80, habits);
    Family family = new Family(father, mother, tom);
    family.addChild(son);
    family.addChild(daughter);
    System.out.println(family);
  }
}
