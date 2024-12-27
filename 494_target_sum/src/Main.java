import java.util.Arrays;

public class Main {
    int res = 0;
    int sum = 0;

    public int memorization(int[] nums, int target, int index, int count, int[][] mem) {
        // x -1 0 1 2 3 4 5
        // 0  0 5 0 0 0 0 0
        // 1  1 0 4 0 0 0 0
        // 2  0 1 0 3 0 0 0
        // 3  0 0 1 0 2 0 0
        // 4  0 0 0 1 0 1 0

        if (index < nums.length && mem[index][count + sum] != Integer.MIN_VALUE) {
            return mem[index][count + sum];
        }

        else if (index == nums.length) {
            if (target == count) {
                return 1;
            }

            return 0;
        }

        int addition = memorization(nums, target, index + 1, count + nums[index], mem);
        int subtract = memorization(nums, target, index + 1, count - nums[index], mem);

        int ways = addition + subtract;
        return mem[index][count + sum] = ways;
    }

    public void backTracking(int[] nums, int target, int index, int count) {
        if (index == nums.length) {
            if (target == count) res++;

            return;
        }

        backTracking(nums, target, index + 1, count + nums[index]);
        backTracking(nums, target, index + 1, count - nums[index]);
    }

    public int findTargetSumWays(int[] nums, int target) {
        sum = Arrays.stream(nums).sum();
        int[][] mem = new int[nums.length][sum * 2 + 1];

        for (int[] m: mem) {
            Arrays.fill(m, Integer.MIN_VALUE);
        }

        memorization(nums, target, 0, 0, mem);

        return mem[0][sum];
        //        backTracking(nums, target, 0, 0);
        // return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};

        var main = new Main();

        System.out.println(main.findTargetSumWays(nums, 3));
    }
}