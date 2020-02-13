package hw01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework_01 {
    public static void main(String[] args) {
        Random random = new Random();
        int random_num = random.nextInt(101);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter your name:  ");
        String name = scanner.nextLine();

        System.out.println("Let the game begin!");

        int guessed_num;
        int[] entered_nums = new int[0];

        while (true) {
            guessed_num = 0;
            boolean isInt = true;

            while (isInt) {
                Scanner scan = new Scanner(System.in);
                System.out.print("Please, enter a number [0:100]:  ");
                if (scan.hasNextInt()) {
                    guessed_num = scan.nextInt();
                    isInt = false;
                } else {
                    System.out.println("You entered non-integer value!");
                }
            }

            entered_nums = fillingEnteredNums(entered_nums, guessed_num);

            if (guessed_num < random_num)
                System.out.println("Your number is too small. Please, try again.");
            else if (guessed_num > random_num)
                System.out.println("Your number is too big. Please, try again.");
            else {
                System.out.printf("Congratulations, %s%s!\n",
                        name.substring(0, 1).toUpperCase(),
                        name.substring(1).toLowerCase());
                System.out.printf("Your numbers: %s", Arrays.toString(entered_nums));
                break;
            }
        }
    }

    private static int[] fillingEnteredNums(int[] prevNums, int newNum) {
        int newLen = prevNums.length + 1;
        prevNums = Arrays.copyOf(prevNums, newLen);
        prevNums[newLen - 1] = newNum;

        Arrays.sort(prevNums);

        int[] reversEnteredNums = new int[newLen];
        for (int i = 0; i < newLen; i++) {
            reversEnteredNums[newLen - 1 - i] = prevNums[i];
        }
        return reversEnteredNums;
    }

}
