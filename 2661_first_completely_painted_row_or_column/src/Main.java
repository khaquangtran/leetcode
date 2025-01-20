import java.util.HashMap;
import java.util.Map;

public class Main {
    private int bruteForce(int[] arr, int[][] mat) {
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

    private int reverseMapping(int[] arr, int[][] mat) {
        // the idea is that, the last paint will always be painted
        // and since we have to find the last paint first time, we need to find the first last paint.

        int rows = mat.length, cols = mat[0].length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int firstTimeLargestPaint = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            int largestIndexPaint = 0;

            for (int j = 0; j < cols; j++) {
                largestIndexPaint = Math.max(map.get(mat[i][j]), largestIndexPaint);
            }

            firstTimeLargestPaint = Math.min(firstTimeLargestPaint, largestIndexPaint);
        }

        for (int i = 0; i < cols; i++) {
            int largestIndexPaint = 0;

            for (int j = 0; j < rows; j++) {
                largestIndexPaint = Math.max(map.get(mat[j][i]), largestIndexPaint);
            }

            firstTimeLargestPaint = Math.min(firstTimeLargestPaint, largestIndexPaint);
        }

        return firstTimeLargestPaint;
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
//        return bruteForce(arr, mat);
        return reverseMapping(arr, mat);
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