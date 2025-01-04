import java.util.Arrays;

public class Main {
    private int backTracking(int m, int n, int i, int j) {
        if (i == m || j == n) return 0;

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        return backTracking(m, n, i + 1, j) + backTracking(m, n, i, j + 1);
    }

    private int memorization(int m, int n, int i, int j, int[][] dp) {
        if (i == m || j == n) return 0;
        else if (dp[i][j] != 0) return dp[i][j];
        else if (i == m - 1 && j == n - 1) return 1;

        return dp[i][j] = memorization(m, n, i + 1, j, dp) + memorization(m, n, i, j + 1, dp);
    }

    public int computeMath(int m, int n) {
        int[][] computes = new int[m][n];

        for (int[] compute : computes) {
            Arrays.fill(compute, 1);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                computes[i][j] = computes[i - 1][j] + computes[i][j - 1];
            }
        }

        return computes[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        // 690285631
        // 2000000000
        //  return backTracking(m, n, 0, 0);
        // int[][] dp = new int[m][n];
        // return memorization(m, n, 0, 0, dp);
        return computeMath(m, n);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.uniquePaths(100, 100));
    }
}