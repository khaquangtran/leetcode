public class Main {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];

        int dayIndex = 0;
        int d = 1;

        while (dayIndex < days.length) {
            if (d == days[dayIndex]) {
                dp[d] = Math.min(dp[d - 1] + costs[0], Math.min(
                       dp[Math.max(0, d - 7)] + costs[1],
                        dp[Math.max(0, d - 30)] + costs[2]
                ));
                dayIndex++;
            } else {
                dp[d] = dp[d - 1];
            }
            d++;
        }

        return dp[days[days.length - 1]];
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(main.mincostTickets(days, costs));
    }
}