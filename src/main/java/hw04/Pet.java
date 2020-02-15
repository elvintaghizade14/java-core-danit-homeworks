package hw04;

import java.util.Arrays;

public class Pet {

    public String species;
    public String nickname;
    public int age;
    public int trickLevel;
    public String[] habits = {};

    public Pet() {
    }

    public Pet(String species) {
        this.nickname = species;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I'm eating");
    }

    public void respond(String nickname) {
        System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
    }

    public void foul() {
        System.out.println("'I need to cover it up");
    }

//    dog{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}, where dog = species;

    @Override
    public String toString() {
        return "dog{" +
                "species='" + "dog" + '\'' +
                ", nickname='" + "Rock" + '\'' +
                ", age=" + 5 +
                ", trickLevel=" + 75 +
                ", habits=" + Arrays.toString(new String[]{"eat", "drink", "sleep"}) +
                '}';
    }
}
