import java.util.Arrays;

public class Main {
    int countWays = 0;

    private void backTracking(int low, int high, int zero, int one, StringBuilder builder) {
        StringBuilder sb = new StringBuilder(builder);
        int builderLength = sb.length();

        if (builderLength > high) return;

        if (builderLength >= low) {
            countWays++;
        }

        sb.append(Character.toString('0').repeat(zero));
        backTracking(low, high, zero, one, sb);
        sb.deleteCharAt(builderLength - 1);

        sb.append(Character.toString('1').repeat(one));
        backTracking(low, high, zero, one, sb);
        sb.deleteCharAt(builderLength - 1);
    }

    private int dynamicProgramming(int low, int high, int zero, int one, int step, int[] dp) {
        if (step > high) return 0;

        if (dp[step] != Integer.MIN_VALUE) return dp[step];

        int ways = 0;

        ways += dynamicProgramming(low, high, zero, one, step + zero, dp);
        ways += dynamicProgramming(low, high, zero, one, step + one, dp);

        ways += step >= low ? 1 : 0;

        return dp[step] = ways % (int)(1e9 + 7);
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        // backTracking(low, high, zero, one, new StringBuilder(Character.toString('0').repeat(zero)));
        // backTracking(low, high, zero, one, new StringBuilder(Character.toString('1').repeat(one)));
        int[] dp = new int[high + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        countWays += dynamicProgramming(low, high, zero, one, zero, dp);
        countWays += dynamicProgramming(low, high, zero, one, one, dp);

        return countWays % (int)(1e9 + 7);
    }

    public static void main(String[] args) {
        Main main = new Main();
        int low = 1000, high = 1000, zero = 2, one = 4;
        System.out.println(main.countGoodStrings(low, high, zero, one));
    }
}