package hw02;

import java.util.Scanner;

public class homework_02 {
    public static void main(String[] args) {

        int[][] area = new int[5][5];

        int targetX = (int) (Math.random() * 5);//column
        int targetY = (int) (Math.random() * 5);//row

        System.out.println(targetY + 1 + " " + (targetX + 1));

        area[targetY][targetX] = 1;

        System.out.println("All set. Get ready to rumble!\n");
        int shotX;
        int shotY;

        while (true) {

            Scanner in = new Scanner(System.in);
            System.out.print("line to shot - [1;5]:  ");
            shotY = in.nextInt() - 1;
            System.out.print("Bar to shot - [1;5]:  ");
            shotX = in.nextInt() - 1;

            if (area[shotY][shotX] != 1) {
                area[shotY][shotX] = -1;
            } else {
                for (int y = 0; y < 5; y++) {
                    if (y == 0) {
                        for (int heaading = 0; heaading < 6; heaading++) {
                            if (heaading != 5)
                                System.out.print(heaading + " | ");
                            else
                                System.out.print(heaading + " |");
                        }
                        System.out.println();
                    }
                    System.out.print((y + 1) + " | ");
                    for (int x = 0; x < 5; x++) {
                        if (area[y][x] == 1) {
                            if (x != 4)
                                System.out.print("x | ");
                            else
                                System.out.print("x |");
                        } else if (area[y][x] == -1) {
                            if (x != 4)
                                System.out.print("* | ");
                            else
                                System.out.print("* |");
                        } else {
                            if (x != 4)
                                System.out.print("- | ");
                            else
                                System.out.print("- |");
                        }
                    }
                    System.out.println();
                }
                System.out.println("You won!");
                break;
            }
        }


    }
}