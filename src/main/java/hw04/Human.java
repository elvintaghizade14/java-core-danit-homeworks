package hw04;

public class Human {
    public String name;
    public String surname;
    public int birthYear;
    public int IQ;
    public Pet pet;
    public Human mother;
    public Human father;
    public String[][] schedule;

    //OWN METHODS
    public void greetPet() {
        System.out.printf("Hello, %s\n", pet.nickname);
    }

    public void describePet() {
        System.out.printf("I have a %s, he is %d years old, he is %s", pet.species, pet.age,
                pet.trickLevel > 50 ? "very sly" : "almost not sly");
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthYear=" + birthYear +
                ", IQ=" + IQ +
                ", mother=" + mother +
                ", father=" + father +
                ", pet=" + pet +
                '}';
    }

    //CONSTRUCTORS
    public Human() {
    }

    public Human(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public Human(String name, String surname, int birthYear, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int birthYear, int IQ, Pet pet,
                 Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.IQ = IQ;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }
}
