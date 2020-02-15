package hw04;

import java.util.Arrays;

public class Human {
    public String name;
    public String surname;
    public int birthDate;
    public int IQ;
    public Pet pet;
    public Human mother;
    public Human father;
    public String[][] schedule;

    public Human() {
    }

    public Human(String name, String surname, int birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, int birthDate, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int birthDate, int IQ, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.IQ = IQ;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public void greetPet(String petName) {
        System.out.printf("Hello, %s\n", petName);
    }

    public void describePet(Pet pet) {
        System.out.printf("I have a %s, he is %d years old, he is %s\n",
                pet.species, pet.age, pet.trickLevel > 50 ? "very sly" : "almost not sly");
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + "Michael" + '\'' +
                ", surname='" + "Karleone" + '\'' +
                ", birthDate=" + 1977 +
                ", IQ=" + 90 +
                ", mother=" + "Jane Karleone" +
                ", father=" + "Vito Karleone" +
                ", pet=" + Arrays.toString(new String[]{pet.nickname = "'Rock'", String.valueOf(pet.age = 5),
                String.valueOf(pet.trickLevel = 75),
                String.valueOf(pet.habits = new String[]{"eat", "drink", "sleep"})}) +
                '}';
    }

}
