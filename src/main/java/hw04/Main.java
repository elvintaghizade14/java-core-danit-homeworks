package hw04;

public class Main {

    public static void main(String[] args) {

        Pet pet = new Pet();
        pet.species = "Dog";
        pet.nickname = "Rock";
        pet.age = 5;
        pet.trickLevel = 75;
        pet.habits = new String[]{"eat", "drink", "sleep"};

        Human mother = new Human("Jane", "Karleone", 1950);

        Human father = new Human("Vito", "Karleone", 1948);

        Human child1 = new Human();
        child1.name = "Michael";
        child1.surname = "Karleone";
        child1.birthYear = 1977;
        child1.IQ = 90;
        child1.mother = mother;
        child1.father = father;
        child1.pet = pet;

        Human child2 = new Human("Romeo", "Karleone", 1978, mother, father);

        child1.greetPet();
        child1.describePet();

        System.out.println(pet);
        System.out.println(child1);
        System.out.println(child2);
    }
}
