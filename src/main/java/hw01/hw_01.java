package hw01;

import java.util.Random;
import java.util.Scanner;

public class hw_01 {
    public static void main(String[] args) {
        //generating random number:
        Random random = new Random();
        int random_num = random.nextInt(101);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter your name:  ");
        String name = scanner.nextLine();

        System.out.println("Let the game begin!");

        int guessed_num, counter = 0;

        int[] entered_nums = new int[100];

        while (true) {
            if (!(counter == 0)) {
                System.out.print("Your numbers: [");
                for (int i = 0; i < counter; i++) {
                    System.out.print("\"" + entered_nums[i] + "\"");

                    if (!(i == (counter - 1))) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("You haven't guessed a number yet.");
            }

            System.out.print("Please, enter a number [0:100]:  ");
            guessed_num = scanner.nextInt();

            entered_nums[counter] = guessed_num;

            counter++;

            if (guessed_num < random_num) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (guessed_num > random_num) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.println("Congratulations, "
                        + name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase()
                        + "!");
                System.out.println("You find hidden number in " + counter + " steps");
                break;
            }
        }//while

    }
}
