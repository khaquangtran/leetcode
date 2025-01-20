import java.util.HashMap;
import java.util.Map;

public class Main {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();

        int[] countRows = new int[rows];
        int[] countCols = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int[] m = map.get(arr[i]);
            int row = m[0];
            int col = m[1];

            countRows[row]++;
            countCols[col]++;

            if (countRows[row] == cols || countCols[col] == rows) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] arr = {1,2,5,6,10,12};
        int[][] mat = {
                {1,10,5},
                {2,12,6}
        };

        System.out.println(main.firstCompleteIndex(arr, mat));
    }
}