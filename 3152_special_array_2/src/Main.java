public class Main {
    public static boolean[] specialArray(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;

        int[] parities = new int[n];

        for (int i = 1; i < n; i++) {
            parities[i] = parities[i - 1];

            if ((nums[i] + nums[i - 1]) % 2 == 0) {
                parities[i] += 1;
            }
        }

        boolean[] ans = new boolean[q];

        for (int i = 0; i < q; i++) {
            int[] query = queries[i];
            ans[i] = parities[query[0]] == parities[query[1]];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,1,6};
        int[][] queries = {{0,2}, {2,3}};

        boolean[] ans = specialArray(nums, queries);

        for (boolean i: ans) {
            System.out.printf("%2b", i);
        }
    }
}