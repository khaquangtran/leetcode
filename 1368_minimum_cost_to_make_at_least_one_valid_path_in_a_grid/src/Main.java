import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public int dijkstra(int[][] grid) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int rows = grid.length, cols = grid[0].length;

        int[][] minCost = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        minCost[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int row = cell[0], col = cell[1], cost = cell[2];

            if (minCost[row][col] > cost) continue;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dirs[i][0], newCol = col + dirs[i][1];

                boolean isCellValid = newRow < rows && newRow >= 0 && newCol < cols && newCol >= 0;

                if (isCellValid) {
                    int newCost = cost + (grid[row][col] != (i + 1) ? 1 : 0);

                    if (minCost[newRow][newCol] > newCost) {
                        minCost[newRow][newCol] = newCost;
                        pq.offer(new int[]{newRow, newCol, newCost});
                    }
                }
            }
        }

        return minCost[rows - 1][cols - 1];
    }

    public int minCost(int[][] grid) {
        return dijkstra(grid);
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[][] grid = new int[][] {
                {1,1,3},
                {3,2,2},
                {1,1,4}
        };

        int cost = main.minCost(grid);

        System.out.println(cost);
    }
}