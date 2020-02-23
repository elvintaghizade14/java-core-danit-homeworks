package hw04;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet("Dog", "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});

        Human mother = new Human("Jane", "Karleone", 1970);

        Human father = new Human("Vito", "Karleone", 1968);

        Human child = new Human("Michael", "Karleone",
                1977, 90, pet, mother, father, new String[][]{{"day1", "day2"}, {"task1", "task2"}});
        child.greetPet();
        child.describePet();

        System.out.println(pet);
        System.out.println(child);
    }
}