/*   Created by IntelliJ IDEA.
 *   Author: Komal Bindal
 *   Date: 07-09-2020
 *   Time: 22:46
 *   File: TicTacToe.java
 */

import java.util.Scanner;

public class TicTacToe {
    private static boolean oWins(char[] arr) {
        int sumOfOForRow = 0, sumOfOForColumn = 0, sumOfOForMajorDiagonal = 0, sumOfOForMinorDiagonal = 0;
        for (int i = 0; i < 9; i += 3) {
            boolean isOWinsForRow = arr[i] == 'O' && arr[i + 1] == 'O' && arr[i + 2] == 'O';
            if (isOWinsForRow) {
                sumOfOForRow = 237;
            }
        }
        for (int i = 0; i < 3; i++) {
            boolean isOWinsForColumn = arr[i] == 'O' && arr[i + 3] == 'O' && arr[i + 6] == 'O';
            if (isOWinsForColumn) {
                sumOfOForColumn = 237;
            }
        }
        sumOfOForMajorDiagonal = arr[0] + arr[4] + arr[8];
        sumOfOForMinorDiagonal = arr[2] + arr[4] + arr[6];
        return sumOfOForRow == 237 || sumOfOForColumn == 237 || sumOfOForMajorDiagonal == 237 || sumOfOForMinorDiagonal == 237;
    }

    private static boolean xWins(char[] arr) {
        int sumOfXForRow = 0, sumOfXForColumn = 0, sumOfXForMajorDiagonal = 0, sumOfXForMinorDiagonal = 0;
        for (int i = 0; i < 9; i += 3) {
            boolean isXWinsForRow = arr[i] == 'X' && arr[i + 1] == 'X' && arr[i + 2] == 'X';
            if (isXWinsForRow) {
                sumOfXForRow = 264;
            }
        }
        for (int i = 0; i < 3; i++) {
            boolean isXWinsForColumn = arr[i] == 'X' && arr[i + 3] == 'X' && arr[i + 6] == 'X';
            if (isXWinsForColumn) {
                sumOfXForColumn = 264;
            }
        }
        sumOfXForMajorDiagonal = arr[0] + arr[4] + arr[8];
        sumOfXForMinorDiagonal = arr[2] + arr[4] + arr[6];
        return sumOfXForRow == 264 || sumOfXForColumn == 264 || sumOfXForMajorDiagonal == 264 || sumOfXForMinorDiagonal == 264;
    }

    private static boolean bothWins(boolean oWins, boolean xWins) {
        return oWins && xWins;
    }

    private static int countFreeSpaces(char[] arr) {
        int freeSpaces = 0;
        for (int i = 0; i < 9; i++) {
            if (arr[i] == ' ' || arr[i] == '_') {
                freeSpaces++;
            }
        }
        return freeSpaces;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = new char[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = ' ';
        }
        System.out.println("add");
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < 9; i += 3) {
            System.out.println(String.format("| %c %c %c |", arr[i], arr[i + 1], arr[i + 2]));
        }
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
        System.out.println();
        int count = 0;
        int xCoordinate;
        int yCoordinate;
        while (true) {
            System.out.print("Enter the coordinates:");
            if (scanner.hasNextInt()) {
                xCoordinate = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    yCoordinate = scanner.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    continue;
                }
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if ((xCoordinate <= 0 || xCoordinate > 3) || (yCoordinate < 1 || yCoordinate > 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            int index;
            if (yCoordinate == 3) {
                index = (xCoordinate + yCoordinate) - 4;
            } else if (yCoordinate == 2) {
                index = xCoordinate + yCoordinate;
            } else {
                index = (xCoordinate + yCoordinate) + 4;
            }
            if (arr[index] == 'O' || arr[index] == 'X') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                if (count % 2 == 0) {
                    arr[index] = 'X';
                    count++;
                } else {
                    arr[index] = 'O';
                    count++;
                }
                for (int i = 0; i < 9; i++) {
                    System.out.print("-");
                }
                System.out.println();
                for (int i = 0; i < 9; i += 3) {
                    System.out.println(String.format("| %c %c %c |", arr[i], arr[i + 1], arr[i + 2]));
                }
                for (int i = 0; i < 9; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            if (oWins(arr) && !bothWins(oWins(arr), xWins(arr))) {
                System.out.println("O wins");
                break;
            } else if (xWins(arr) && !bothWins(oWins(arr), xWins(arr))) {
                System.out.println("X wins");
                break;
            } else if (countFreeSpaces(arr) == 0) {
                System.out.println("Draw");
                break;
            } else {
                continue;
            }
        }
        scanner.close();
    }
}

