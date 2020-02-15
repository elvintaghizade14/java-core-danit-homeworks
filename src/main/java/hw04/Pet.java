package hw04;

import java.util.Arrays;

public class Pet {

    public String species;
    public String nickname;
    public int age;
    public int trickLevel;
    public String[] habits;

    public void eat() {
        System.out.println("I am eating");
    }

    public void respond(String nickname) {
        System.out.printf("I am %s. I miss you!\n", nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    @Override
    public String toString() {
        return "dog{" + "species='" + "dog" + '\'' + ", nickname='" + "Rock" + '\'' +
                ", age=" + 5 + ", trickLevel=" + 75 + ", habits=" +
                Arrays.toString(new String[]{"eat", "drink", "sleep"}) + '}';
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }
}
