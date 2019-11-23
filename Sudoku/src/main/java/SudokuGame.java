import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuGame {

    private static Integer[][] arrayGame = new Integer[9][9];
    private static int row = 0;

    public static void main(String[] args) {

        readSudokuFromUser();

        if (isValidSudoku())
            System.out.println("Yes it's valid Sudoku Game");
        else
            System.out.println("Not valid Sudoku Game");
    }

    private static void readSudokuFromUser() {
        System.out.println("Hello ..");
        System.out.println("please enter the game .. \n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 13; i++) {
            try {
                String line = reader.readLine();
                fillInArrayGame(line);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isValidSudoku() {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!checkBoxesValidity(row, col)) {
                    return false;
                }
            }
        }
        return checkColumnsAndRowsValidity();
    }

    private static boolean checkBoxesValidity(int startRow, int startColumn) {
        Set<Integer> set = new HashSet<>();
        for (int row = 0; row < 3; row++) {
            set.addAll(Arrays.asList(arrayGame[startRow + row])
                    .subList(startColumn, 3 + startColumn));
        }
        return set.size() == 9;
    }

    private static boolean checkColumnsAndRowsValidity() {
        for (int row = 0; row < 9; row++) {
            Set<Integer> rowsSet = new HashSet<>(Arrays.asList(arrayGame[row]));
            if (rowsSet.size() != 9)
                return false;

            Set<Integer> colSet = new HashSet<>();
            for (int column = 0; column < 9; column++)
                colSet.add(arrayGame[row][column]);
            if (colSet.size() != 9)
                return false;
        }
        return true;
    }

    private static void fillInArrayGame(String currentLine) {
        int column = 0;
        for (char character : currentLine.toCharArray())
            if (Character.isDigit(character)) {
                arrayGame[row][column] = Character.getNumericValue(character);
                column++;
                if (column == 9)
                    row++;
            }
    }
}

