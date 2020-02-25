package hw05;

public class Main {
    public static void main(String[] args) {
        String[] habits = {"code", "eat", "sleep"};
        Human father = new Human("fatherName", "fatherSurname", 1900);
        Human mother = new Human("motherNme", "motherSurname", 1905);
        Family family = new Family(father, mother);
        Human son = new Human("son", "sonSurname", 1930);
        Human daughter = new Human("daughter", "daughterSurname", 1932);
        Human son2 = new Human("abc", "ABCDEFG", 1928, 150,
                new String[][]{{"MONDAY", "Task_1"}, {"TUESDAY", "task_2"}, {"FRIDAY", "Task3"}}, family);
        Pet pet = new Pet("Horse", "AT:)", 3, 75, habits);

        family.addChild(son);
        family.addChild(daughter);
        family.setPet(pet);
        family.addChild(son2);
//        System.out.println(family.countFamily());
        System.out.println(family);
//        family.deleteChild(0);
//        System.out.println(family);
//        System.out.println(family.countFamily());
    }
}
