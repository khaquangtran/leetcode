import java.util.Arrays;

public class Main {
    private int backTracking(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i == m || j == n) return (int)1e9;
        else if (i == m - 1 && j == n - 1) return grid[i][j];

        return grid[i][j] + Math.min(backTracking(grid, i + 1, j), backTracking(grid, i, j + 1));
    }

    private int memorization(int[][] grid, int i, int j, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (i == m || j == n) return 200;
        else if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        else if (i == m - 1 && j == n - 1) return grid[i][j];

        return dp[i][j] = grid[i][j] + Math.min(memorization(grid, i + 1, j, dp), memorization(grid, i, j + 1, dp));
    }

    public int minPathSum(int[][] grid) {
        // return backTracking(grid, 0, 0);
        int[][] dp = new int[grid.length][grid[0].length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return memorization(grid, 0, 0, dp);
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[][] grids = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(main.minPathSum(grids));
    }
}