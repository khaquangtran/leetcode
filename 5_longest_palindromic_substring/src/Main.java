public class Main {
    private String dynamicProgramming(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int frontIndex = 0, backIndex = 0;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                frontIndex = i;
                backIndex = i + 1;
            }
        }


        for (int distance = 2; distance < n; distance++) {
            for (int i = 0; i < n - distance; i++) {
                int j = i + distance;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    frontIndex = i;
                    backIndex = j;
                }
            }
        }

        return s.substring(frontIndex, backIndex + 1);
    }

    public String longestPalindrome(String s) {
        return dynamicProgramming(s);
    }

    public static void main(String[] args) {
        Main main = new Main();

        String s = "aaaaaaaaaaaaaaa";

        System.out.println(main.longestPalindrome(s));
    }
}