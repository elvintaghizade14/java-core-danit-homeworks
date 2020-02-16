package hw02;

import java.util.Scanner;

public class homework_02_v3 {
    public static void main(String[] args) {
        boolean cont = true;
        while (cont) {
            char[][] area = new char[6][6];
            int targetY = (int) (Math.random() * 5 + 1);//row
            int targetX = (int) (Math.random() * 5 + 1);//column
            System.out.println("Line = " + targetY + ". Bar = " + targetX);
            System.out.println("All set. Get ready to rumble!\n");
            drawAreaFirst(area);
            boolean flag = true;
            while (flag) {
                int shotY = shotValue("Line");
                int shotX = shotValue("Bar");
                if ((shotX != targetX) || (shotY != targetY)) {
                    area[shotY][shotX] = '*';
                    drawArea(area);
                } else {
                    area[targetY][targetX] = 'x';
                    drawArea(area);
                    flag = false;
                }
            }
            cont = endGame();
        }
    }

    public static int shotValue(String s) {
        int shotValue = 0;
        boolean isInt = true;
        while (isInt) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(s + " to shot - [1;5]:  ");
            if (scanner.hasNextInt()) {
                shotValue = scanner.nextInt();
                while (shotValue < 1 || shotValue > 5) {
                    System.out.println("You entered wrong value. Try again!");
                    System.out.print(s + " to shot - [1;5]:  ");
                    shotValue = scanner.nextInt();
                }
                isInt = false;
            } else {
                System.out.println("You entered wrong value. Try again!");
            }
        }
        return shotValue;
    }

    public static void drawAreaFirst(char[][] area) {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if (y == 0) {
                    area[y][x] = (char) (x + 48);
                } else if (x == 0) {
                    area[y][x] = (char) (y + 48);
                } else {
                    area[y][x] = '-';
                }
                if (x != 5) System.out.print(area[y][x] + " | ");
                else System.out.print(area[y][x] + " |");
            }
            System.out.println();
        }
    }

    public static void drawArea(char[][] area) {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if (x != 5) System.out.print(area[y][x] + " | ");
                else System.out.print(area[y][x] + " |");
            }
            System.out.println();
        }
    }

    public static boolean endGame() {
        System.out.println("Do you wanna start again? (y/n) or (Y/N)");
        Scanner endGame = new Scanner(System.in);
        String newGame = endGame.next();
        return newGame.equalsIgnoreCase("y");
    }
}
