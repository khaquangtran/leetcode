public class Main {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length,  cols = matrix[0].length;
        int low = 0, high = (rows * cols) - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int row = mid / cols;
            int col = mid % cols;

            int currentValue = matrix[row][col];

            if (currentValue == target) {
                return true;
            } else if (currentValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[][] matrix = {
                {1},
                {3},
                {5},
                {7},
                {9}
        };

        int target = 3;

        System.out.println(main.searchMatrix(matrix, target));
    }
}