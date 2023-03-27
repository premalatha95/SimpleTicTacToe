package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        final int N = 3;
        int i, j;
        int spaceCount = 9;
        char[][] array = new char[3][3];
        boolean xWin = false;
        boolean oWin = false;

        System.out.println("---------");
        for (i = 0; i < N; i++) {
             System.out.print("| ");
             for (j = 0; j < N; j++) {
                 array[i][j] = ' ';
                 System.out.print(array[i][j] + " ");

             }
             System.out.println("|");
        }
        System.out.println("---------");
        boolean player1 = true;
        int row, col;
        do {
            try{
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (row < 1 || row > 3 || col > 3 || col < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (array[row - 1][col - 1] == ' ') {
                    if (player1) {
                        array[row - 1][col - 1] = 'X';
                    } else {
                        array[row - 1][col - 1] = 'O';
                    }

                    System.out.println("---------");

                    for (i = 0; i < N; i++) {
                        System.out.print("| ");
                        for (j = 0; j < N; j++) {
                            System.out.print(array[i][j] + " ");
                        }
                        System.out.println("|");
                    }

                    System.out.println("---------");
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
            } catch (NumberFormatException e){
                System.out.println("You should enter numbers!");
                continue;
            }

            for (int k = 0; k < N; k++) {
                int l = 0;

                if (array[k][l] == array[k][l + 1] && array[k][l] == array[k][l + 2]) {
                    if (array[k][l] == 'X') {
                        xWin = true;
                    } else if (array[k][l] == 'O') {
                        oWin = true;
                    }
                }

                if (array[l][k] == array[l + 1][k] && array[l][k] == array[l + 2][k]) {
                    if (array[l][k] == 'X') {
                        xWin = true;
                    } else if (array[l][k] == 'O') {
                        oWin = true;
                    }
                }

                if (k == 1) {
                    if ((array[k][k] == array[l][k - 1] && array[k][k] == array[k + 1][l + 2]) || (array[k][k] == array[k + 1][l] && array[k][k] == array[l][k + 1])) {
                        if (array[k][k] == 'X') {
                            xWin = true;
                        } else if (array[k][k] == 'O') {
                            oWin = true;
                        }
                    }
                }
            }
            if (xWin) {
                System.out.println("X wins");
                break;
            } else if (oWin) {
                System.out.println("O wins");
                break;
            } else if (spaceCount <= 0) {
                System.out.println("Draw");
                break;
            }
            player1 = !player1;
            spaceCount--;
        } while (true);

    }
}

