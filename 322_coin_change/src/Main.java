import java.util.Arrays;

public class Main {
    private int optimized(int[] coins, int amount) {
        if (amount == 0) return 0;

        int n = amount + 1;
        int[] minimumChanges = new int[n];

        Arrays.fill(minimumChanges, Integer.MAX_VALUE);

        for (int coin : coins) {
            if (coin <= amount) minimumChanges[coin] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int coin : coins) {
                if (coin > i || minimumChanges[i - coin] == Integer.MAX_VALUE) continue;

                minimumChanges[i] = Math.min(minimumChanges[i], minimumChanges[coin] + minimumChanges[i - coin]);
            }
        }

        if (minimumChanges[amount] == Integer.MAX_VALUE) return -1;

        return minimumChanges[amount];
    }

    public int coinChange(int[] coins, int amount) {
        return optimized(coins, amount);
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] coins = {1,2,5,2147483647};
        int amount = 1000;

        System.out.println(main.coinChange(coins, amount));
    }
}