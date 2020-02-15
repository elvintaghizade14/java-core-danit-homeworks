package hw03;

import java.util.Scanner;

public class homework_03 {
    public static void main(String[] args) {
        // 1. declaration
        String[][] schedule = new String[7][2];

        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.print("Please, input the day of the week:  ");
            String day = scan.nextLine().trim().toLowerCase();

            while (!day.equals("monday") && !day.equals("tuesday") && !day.equals("wednesday") &&
                    !day.equals("thursday") && !day.equals("friday") && !day.equals("saturday") &&
                    !day.equals("sunday") && !day.equals("exit")) {
                System.out.println("Sorry, I don't understand you, please try again.");
                System.out.print("Please, input the day of the week:  ");
                day = scan.nextLine().trim().toLowerCase();
            }

            if (day.equals("exit")) break;

            switch (day) {
                case "sunday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[0][0], schedule[0][1]);
                    break;
                case "monday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[1][0], schedule[1][1]);
                    break;
                case "tuesday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[2][0], schedule[2][1]);
                    break;
                case "wednesday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[3][0], schedule[3][1]);
                    break;
                case "thursday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[4][0], schedule[4][1]);
                    break;
                case "friday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[5][0], schedule[5][1]);
                    break;
                case "saturday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[6][0], schedule[6][1]);
                    break;
            }

        }
    }
}
