package hw07.classes;

public class Main {
  public static void main(String[] args) throws Throwable {
    for (int i = 0; i < 10000; i++) {
      Human human = new Human() {
        @Override
        public void greetPet() {
          System.out.println("Hello");
        }
      };
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

    Man father = new Man("Father", "FATHERSURNAME", 1970, schedule);
    father.repairCar();
    father.greetPet();
    Woman mother = new Woman("Mother", "MOTHERSURNAME", 1975, schedule);
    mother.makeUp();
    mother.greetPet();
    Human son = new Human("son", "SONSURNAME", 1995, schedule) {
      @Override
      public void greetPet() {
        System.out.printf("Hello, %s", getFamily().getPet().getNickname());
      }
    };
    Human daughter = new Human("Daughter", "DAUGHTERSURNAME", 1999, schedule) {
      @Override
      public void greetPet() {
        System.out.printf("Hello, %s", getFamily().getPet().getNickname());
      }
    };
    DomesticCat tom = new DomesticCat("TOM", 3, 80, habits);
    Family family = new Family(father, mother, tom);
    family.addChild(son);
    family.addChild(daughter);
    System.out.println(family);
    family.finalize();
    mother.finalize();
    father.finalize();
  }
}
