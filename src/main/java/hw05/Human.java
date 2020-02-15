package hw05;

public class Human {
    private String name;
    private String surname;
    private int birthYear;
    private int IQ;
    private Human mother;
    private Human father;
    private Pet pet;
    private String[][] schedule;

    private void greetPet() {
        System.out.printf("Hello, %s", pet.getNickname());
    }

    private void describePet() {
        System.out.printf("I have a %s, he is %d years old, he is %s",
                pet.getSpecies(), pet.getAge(), pet.getTrickLevel() > 50 ? "very sly" : "almost not sly");
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }
}
