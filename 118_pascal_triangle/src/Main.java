import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();

        rows.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j = 1; j < i; j++) {
                List<Integer> lastRow = rows.getLast();
                row.add(lastRow.get(j - 1) + lastRow.get(j));
            }

            row.add(1);

            rows.add(row);
        }


        return rows;
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<List<Integer>> rows = main.generate(5);

        for (List<Integer> row : rows) {
            for (Integer i : row) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }
}