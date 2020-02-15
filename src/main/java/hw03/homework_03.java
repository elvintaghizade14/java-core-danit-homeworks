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
                    if (schedule[0][1] == null) schedule[0][1] = "There is no any task for this day :)";
                    System.out.printf("Your tasks for Sunday: %s\n", schedule[0][1]);
                    break;
                case "monday":
                    if (schedule[1][1] == null) schedule[1][1] = "There is no any task for this day :)";
                    System.out.printf("Your tasks for Monday: %s\n", schedule[1][1]);
                    break;
                case "tuesday":
                    if (schedule[2][1] == null) schedule[2][1] = "There is no any task for this day :)";
                    System.out.printf("Your tasks for Tuesday: %s\n", schedule[2][1]);
                    break;
                case "wednesday":
                    if (schedule[3][1] == null) schedule[3][1] = "There is no any task for this day :)";
                    System.out.printf("Your tasks for Wednesday: %s\n", schedule[3][1]);
                    break;
                case "thursday":
                    if (schedule[4][1] == null) schedule[4][1] = "There is no any task for this day :)";
                    System.out.printf("Your tasks for Thursday: %s\n", schedule[4][1]);
                    break;
                case "friday":
                    if (schedule[5][1] == null) schedule[5][1] = "There is no any task for this day :)";
                    System.out.printf("Your tasks for Friday: %s\n", schedule[5][1]);
                    break;
                case "saturday":
                    if (schedule[6][1] == null) schedule[6][1] = "There is no any task for this day :)";
                    System.out.printf("Your tasks for Saturday: %s\n", schedule[6][1]);
                    break;
            }
        }
    }
}
