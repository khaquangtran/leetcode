import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] words = {"acca", "bbbb", "caca"};
        String target = "aba";

        Main main = new Main();

        System.out.println(main.numWays(words, target));
    }

    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();

        int[][] dp = new int[wordLength][targetLength];
        int[][] charFreq = new int[wordLength][26];

        for (int i = 0; i < wordLength; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        // 0 - 2 0 2
        // 1 - 0 4 0
        // 2 - 2 0 2

        //


        for (String word : words) {
            for (int j = 0; j < wordLength; j++) {
                int c = word.charAt(j) - 'a';
                charFreq[j][c]++;
            }
        }

        int ans = (int) topDown(words, target, 0, 0, dp, charFreq);

        for (int[] m : dp) {
            for (int a : m) {
                System.out.printf("%10d", a);
            }

            System.out.println();
        }

        return ans;
    }

    private long topDown(String[] words, String target, int wordsIndex, int targetIndex, int[][] dp, int[][] charFrequency) {
        int MOD = 1000000007;

        if (targetIndex == target.length()) return 1;

        if (wordsIndex == words[0].length() || words[0].length() - wordsIndex < target.length() - targetIndex) return 0;

        if (dp[wordsIndex][targetIndex] != Integer.MIN_VALUE) return dp[wordsIndex][targetIndex];

        long countWays = 0;
        int curPos = target.charAt(targetIndex) - 'a';

        countWays += topDown(words, target, wordsIndex + 1, targetIndex, dp, charFrequency);

        countWays += charFrequency[wordsIndex][curPos] * topDown(words, target, wordsIndex + 1, targetIndex + 1, dp, charFrequency);

        return dp[wordsIndex][targetIndex] = (int) (countWays % MOD);
    }
}
