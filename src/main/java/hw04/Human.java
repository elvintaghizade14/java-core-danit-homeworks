package hw04;

public class Human {
    public String name;
    public String surname;
    public int year;
    public int iq;
    public Pet pet;
    public Human mother;
    public Human father;
    public String[][] schedule;


    public void greetPet() {
        System.out.printf("Hello, %s.\n", pet.nickname);
    }

    public void describePet() {
        System.out.printf("I have a %s, he is %d years old, he is %s.\n",
                pet.species, pet.age, pet.trickLevel > 50 ? "very sly" : "almost not sly");
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, mother=%s %s, father=%s %s, pet=%s.",
                name, surname, year, iq, mother.name, mother.surname, father.name, father.surname, pet);
    }

    // CONSTRUCTORS

    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }
}
