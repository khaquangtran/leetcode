import java.util.Arrays;

public class Main {
    private int backTracking(int n, int climb) {
        if (climb > n) return 0;

        if (climb == n) return 1;

        return backTracking(n, climb + 1) + backTracking(n, climb + 2);
    }

    private int dynamicProgramming(int n, int climb, int[] dp) {
        if (climb > n) return 0;
        else if (climb == n) return 1;

        if (dp[climb] != Integer.MIN_VALUE) return dp[climb];

        return dp[climb] = dynamicProgramming(n, climb + 1, dp) + dynamicProgramming(n, climb + 2, dp);
    }

    private int spaceOptimization(int n) {
        int firstStep = 0;
        int secondStep = 1;

        for (int i = 0; i < n; i++) {
            int temp = secondStep;
            secondStep += firstStep;
            firstStep = temp;
        }

        return secondStep;
    }

    public int climbStairs(int n) {
        /*
        return backTracking(n, 1) + backTracking(n, 2);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return dynamicProgramming(n, 1, dp) + dynamicProgramming(n, 2, dp);
        */
        return spaceOptimization(n);
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] testCases = {1,2,3,4,5,6,7,8,9,10};

        for (int testCase : testCases) {
            System.out.println(main.climbStairs(testCase));
        }
    }
}