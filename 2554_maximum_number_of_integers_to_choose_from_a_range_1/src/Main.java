public class Main {
    public static int maxCount(int[] banned, int n, int maxSum) {
        boolean[] b = new boolean[100001];

        for (int i: banned) b[i] = true;

        int count = 0, sum = 0;

        for (int i = 1; i <= n; i++) {
            if (!b[i] && sum + i <= maxSum) {
                sum += i;
                count++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        int[] banned = {1,6,5};
        int n = 5, maxSum = 6;

        System.out.println(maxCount(banned, n, maxSum));
    }
}