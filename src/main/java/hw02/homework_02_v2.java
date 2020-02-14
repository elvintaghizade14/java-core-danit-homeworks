package hw02;

import java.util.Scanner;

public class homework_02_v2 {
    public static void main(String[] args) {
        char[][] area = new char[5][5];

        int targetX = (int) (Math.random() * 5);//column
        int targetY = (int) (Math.random() * 5);//row

//        System.out.println(targetY + 1 + " " + (targetX + 1)); - to know where target placed for make your work easier, Farid

        System.out.println("All set. Get ready to rumble!\n");

        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area.length; j++) {
                area[i][j] = '-';
            }
        }

        area[targetY][targetX] = 'x';
        int shotX;
        int shotY;

        while (true) {
            shotX = 0;
            shotY = 0;
            boolean isInt = true;
            while (isInt) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Line to shot - [1;5]:  ");
                if (scanner.hasNextInt()) {
                    shotY = scanner.nextInt() - 1;
                    isInt = false;
                } else {
                    System.out.println("You entered wrong value. Try again!");
                }
            }
            isInt = true;
            while (isInt) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Bar to shot - [1;5]:  ");
                if (scanner.hasNextInt()) {
                    shotX = scanner.nextInt() - 1;
                    isInt = false;
                } else {
                    System.out.println("You entered wrong value. Try again!");
                }
            }

            if (area[shotY][shotX] != 'x') {
                area[shotY][shotX] = '*';
            } else {
                for (int y = 0; y < 5; y++) {
                    if (y == 0) {
                        drawHeader(area, y);
                    }
                    System.out.print((y + 1) + " | ");
                    drawBody(area, y);
                }
                break;
            }

        }
    }

    private static void drawBody(char[][] area, int y) {
        for (int x = 0; x < 5; x++) {
            if (x != 4)
                System.out.print(area[y][x] + " | ");
            else
                System.out.print(area[y][x] + " |");
        }
        System.out.println();
    }

    private static void drawHeader(char[][] area, int y) {
        for (int heaading = 0; heaading < 6; heaading++) {
            if (heaading != 5)
                System.out.print(heaading + " | ");
            else
                System.out.print(heaading + " |");
        }
        System.out.println();
    }
}
