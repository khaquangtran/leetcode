import java.util.ArrayList;
import java.util.List;

class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    List<List<String>> boards = new ArrayList<>();
    List<List<Cell>> listOfCells = new ArrayList<>();

    private boolean isValid(List<Cell> cells, int row, int col) {
        for (Cell cell: cells) {
            if (col == cell.x) {
                return false;
            } else if (Math.abs(row - cell.y) == Math.abs(col - cell.x)) {
                return false;
            }
        }

        return true;
    }

    private void backTracking(List<Cell> cells, int n, int row) {
        if (row == n) {
            listOfCells.add(new ArrayList<>(cells));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(cells, row, i)) {
                cells.add(new Cell(i, row));
                backTracking(cells, n, row + 1);
                cells.removeLast();
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        backTracking(new ArrayList<>(), n, 0);

        for (List<Cell> cells : listOfCells) {
            List<String> board = new ArrayList<>();

            for (Cell cell: cells) {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    if (i == cell.x) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }

                board.add(sb.toString());
            }

            boards.add(board);
        }

        return boards;
    }

    public static void main(String[] args) {
        Main main = new Main();

        List<List<String>> boards = main.solveNQueens(4);

        for (List<String> board : boards) {
            for (String b: board) {
                System.out.println(b);
            }

            System.out.println();
        }
    }
}