import java.util.PriorityQueue;

class Cell implements Comparable<Cell> {
    int row;
    int col;
    int height;

    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }

    @Override
    public int compareTo(Cell cell) {
        return Integer.compare(this.height, cell.height);
    }
}

public class Main {
    final int[] directions = {0, -1, 0, 1, 0};

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length, cols = heightMap[0].length;

        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<Cell> pq = new PriorityQueue<>();

        for (int col = 0; col < cols; col++) {
            pq.offer(new Cell(0, col, heightMap[0][col]));
            pq.offer(new Cell(rows - 1, col, heightMap[rows - 1][col]));

            visited[0][col] = true;
            visited[rows - 1][col] = true;
        }

        for (int row = 0; row < rows; row++) {
            pq.offer(new Cell(row, 0, heightMap[row][0]));
            pq.offer(new Cell(row, cols - 1, heightMap[row][cols - 1]));

            visited[row][0] = true;
            visited[row][cols - 1] = true;
        }

        int waters = 0;

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            int row = cell.row, col = cell.col, height = cell.height;

            for (int i = 1; i <= 4; i++) {
                int nextRow = row + directions[i - 1];
                int nextCol = col + directions[i];

                if (isValid(nextRow, nextCol, rows, cols) && !visited[nextRow][nextCol]) {
                    int nextHeight = heightMap[nextRow][nextCol];

                    if (nextHeight < height) {
                        waters += height - nextHeight;
                    }

                    pq.offer(new Cell(nextRow, nextCol, Math.max(height, nextHeight)));

                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return waters;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[][] heightMap = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,2,2,3,1}
        };

        System.out.println(main.trapRainWater(heightMap));
    }
}