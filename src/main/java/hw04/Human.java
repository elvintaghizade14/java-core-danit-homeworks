package hw04;

public class Human {

    public String name;
    public String surname;
    public int birthYear;
    public int IQ;
    public Human mother;
    public Human father;
    public Pet pet;
    public String[][] schedule;

    public void greetPet() {
        System.out.printf("Hello, %s\n", pet.nickname);
    }

    public void describePet() {
        System.out.printf("I have a %s, he is %d years old, he is %s\n",
                pet.species, pet.age, pet.trickLevel > 50 ? "very sly" : "almost not sly");
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthYear=" + birthYear +
                ", IQ=" + IQ +
                ", mother='" + mother + "'" +
                ", father='" + father + "" +
                ", pet=" + pet +
                '}';
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

    public Human(String name, String surname, int birthYear, int IQ,
                 Human mother, Human father, Pet pet, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.IQ = IQ;
        this.mother = mother;
        this.father = father;
        this.pet = pet;
        this.schedule = schedule;
    }

    public Human() {
    }
}

