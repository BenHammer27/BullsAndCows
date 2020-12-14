import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int size = input*input;
        int[][] sudoku = new int [size][size];

        for (int row = 0; row < size; row++) {
            for (int collum = 0; collum < size; collum++){
                sudoku [row][collum] = scanner.nextInt();
            }
        }
        printSudoku(sudoku);
        int sum = 0;
        for (int i = 1; i <= size; i++) {
            sum += i;
        }
        System.out.println(sum);

        int sumRow = 0;
        int sumCollum = 0;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                sumRow += sudoku [r][c];
            }
            if (sumRow == sum) {
                System.out.println(true);
            }
            sumRow = 0;
        }

        for (int co = 0; co < size; co++) {
            for (int ro = 0; ro < size; ro++) {
                sumCollum += sudoku [ro][co];
            }
            if (sumCollum == sum) {
                System.out.println(true);
            }
            sumCollum = 0;
        }

    }

    public static void printSudoku (int [][] sudoku) {
        for (int row = 0; row < sudoku.length; row++) {
            for (int collum = 0; collum < sudoku.length; collum++) {
                if (collum == sudoku.length-1) {
                    System.out.print(sudoku[row][collum] + " \n");
                } else {
                    System.out.print(sudoku[row][collum] + " ");
                }
            }
        }
    }
}