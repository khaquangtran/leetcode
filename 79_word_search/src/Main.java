public class Main {
    private boolean depthFirstSearch(char[][] board, boolean[][] visited, String word, int targetIndex, int i, int j) {
        int m = board.length, n = board[0].length;

        if (board[i][j] == word.charAt(targetIndex) && !visited[i][j]) {
            visited[i][j] = true;
            targetIndex++;
        } else {
            return false;
        }

        if (targetIndex == word.length()) {
            return true;
        }

        boolean right = false, left = false, top = false, bottom = false;

        if (j + 1 < n) {
            right = depthFirstSearch(board, visited, word, targetIndex, i, j + 1);
        }

        if (j - 1 >= 0) {
            left = depthFirstSearch(board, visited, word, targetIndex, i, j - 1);
        }

        if (i - 1 >= 0) {
            top = depthFirstSearch(board, visited, word, targetIndex, i - 1, j);
        }

        if (i + 1 < m) {
            bottom = depthFirstSearch(board, visited, word, targetIndex, i + 1, j);
        }

        visited[i][j] = false;

        return right || left || top || bottom;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (depthFirstSearch(board, new boolean[board.length][board[0].length], word, 0, i, j)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}
        };
        String word = "ABCESEEEFS";

        Main main = new Main();

        System.out.println(main.exist(board, word));
    }
}