package hw04;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.species = "Dog";
        pet.nickname = "Rock";
        pet.age = 5;
        pet.trickLevel = 75;
        pet.habits = new String[]{"eat", "drink", "sleep"};

        Human mother = new Human();
        mother.name = "Jane";
        mother.surname = "Karleone";

        Human father = new Human();
        father.name = "Vito";
        father.surname = "Karleone";

        Human child = new Human();
        child.name = "Michael";
        child.surname = "Karleone";
        child.birthYear = 1977;
        child.IQ = 90;
        child.mother = mother;
        child.father = father;
        child.pet = pet;
        child.greetPet();
        child.describePet();

        System.out.println(pet);
        System.out.println(child);
    }
}
