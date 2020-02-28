package hw06;

public class Main {
  public static void main(String[] args) {
    for (int i = 0; i < 1000000; i++) {
      Human human = new Human();
      System.out.println("Human object created...");
    }

    String[] habits = {"coffee", "code", "sleeping", "Pet is a programmer :)"};

    String[][] schedule = new String[2][7];
    schedule[0][0] = DayOfWeek.MONDAY.name();
    schedule[0][1] = DayOfWeek.TUESDAY.name();
    schedule[0][2] = DayOfWeek.WEDNESDAY.name();
    schedule[0][3] = DayOfWeek.THURSDAY.name();
    schedule[0][4] = DayOfWeek.FRIDAY.name();
    schedule[0][5] = DayOfWeek.SATURDAY.name();
    schedule[0][6] = DayOfWeek.SUNDAY.name();
    schedule[1][0] = "TASK_1";
    schedule[1][1] = "TASK_2";
    schedule[1][2] = "TASK_3";
    schedule[1][3] = "TASK_4";
    schedule[1][4] = "TASK_5";
    schedule[1][5] = "TASK_6";
    schedule[1][6] = "TASK_7";

    Human father = new Human("Father", "FATHERSURNAME", 70);
    father.setSchedule(schedule);
    Human mother = new Human("Mother", "MOTHERSURNAME", 65);
    mother.setSchedule(schedule);
    Human son = new Human("son", "SONSURNAME", 40);
    son.setSchedule(schedule);
    Human daughter = new Human("Daughter", "DAUGHTERSURNAME", 39);
    daughter.setSchedule(schedule);
    Pet pet = new Pet(Species.DOG, "Dog", 3, 75, habits);

    System.out.println(pet);

    Family family = new Family(father, mother);
    family.addChild(son);
    family.addChild(daughter);
    family.setPet(pet);
    System.out.println(family);
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Finalize in Main class...");
    super.finalize();
  }
}
