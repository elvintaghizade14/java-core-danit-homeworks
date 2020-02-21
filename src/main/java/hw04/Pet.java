package hw04;

import java.util.Arrays;

public class Pet {
    public String species;
    public String nickname;
    public int age;
    public int trickLevel;
    public String[] habits;

    public void eat() {
        System.out.println("I am eating.\n");
    }

    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up.\n");
    }

    @Override
    public String toString() {
        return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}.",
                species, nickname, age, trickLevel, Arrays.toString(habits));
    }

    //CONSTRUCTORS

    public Pet() {
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
}
