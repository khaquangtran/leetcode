import java.util.Arrays;

public class Main {
    public static int maxTwoEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int[] suffix = new int[n];
        suffix[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(events[i][2], suffix[i + 1]);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (events[i][1] < events[mid][0]) {
                    high = mid - 1;
                    res = Math.max(res, events[i][2] + suffix[mid]);
                } else {
                    low = mid + 1;
                }

            }

            res = Math.max(res, events[i][2]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(maxTwoEvents(events));
    }
}