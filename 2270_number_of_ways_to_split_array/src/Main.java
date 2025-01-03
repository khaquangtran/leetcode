import java.util.Arrays;

public class Main {
    private int prefixSum(int[] nums) {
        long[] prefix = new long[nums.length];

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }

        int lastIndex = nums.length - 1;
        int ways = 0;

        for (int i = 0; i < lastIndex; i++) {
            long left = prefix[i];
            long right = prefix[lastIndex] - left;
            if (left >= right) ways++;
        }

        return ways;
    }

    private int optimizePrefixAndSuffix(int[] nums) {
        long leftSum = 0, rightSum = 0;

        for (int num : nums) rightSum += num;

        int ways = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];

            rightSum -= num;
            leftSum += num;

            if (leftSum >= rightSum) ways++;
        }

        return ways;
    }

    public int waysToSplitArray(int[] nums) {
//        return optimizePrefixAndSuffix(nums);
        return prefixSum(nums);
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {2, 3, 1, 0};
        System.out.println(main.waysToSplitArray(nums));
    }
}