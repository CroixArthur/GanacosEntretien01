public class App {
    private static boolean checkColumns(int[][] sudoku)
    {
        int counter = 1;

        for (int i = 0; i < 9; i++, counter = 1) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == counter) {
                    counter++;
                    j = -1;
                }
            }
            if (counter < 9)
                return false;
        }
        return true;
    }

    private static boolean checkLines(int[][] sudoku)
    {
        int counter = 1;

        for (int i = 0; i < 9; i++, counter = 1) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[j][i] == counter) {
                    counter++;
                    j = -1;
                }
            }
            if (counter < 9)
                return false;
        }
        return true;
    }

    private static boolean checkSection(int[][] sudoku, int i, int j)
    {
        int counter = 1;

        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                if (sudoku[x][y] == counter) {
                    counter++;
                    y = j-1;
                    x = i-i;
                }
            }
        }
        if (counter < 9)
            return false;
        return true;
    }

    private static boolean checkBlocks(int[][] sudoku)
    {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (checkSection(sudoku, i, j) == false)
                    return false;
            }
        }
        return true;
    }

    public static boolean isSudokuValid(int[][] sudoku)
    {
        if (checkColumns(sudoku) == true
            && checkLines(sudoku) == true
            && checkBlocks(sudoku) == true)
            return true;
        return false;
    }

    public static void main(String[] args)
    {
        int[][] documentTest = {{
            4,1,5,6,3,8,9,7,2
        },{
            3,6,2,4,7,9,1,8,5
        },{
            7,8,9,2,1,5,3,6,4
        },{
            9,2,6,3,4,1,7,5,8
        },{
            1,3,8,7,5,6,4,2,9
        },{
            5,7,4,9,8,2,6,3,1
        },{
            2,5,7,1,6,4,8,9,3
        },{
            8,4,3,5,9,7,2,1,6
        },{
            6,9,1,8,2,3,5,4,7
        }};

        System.out.println(isSudokuValid(documentTest));
    }
}