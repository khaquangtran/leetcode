public class Main {
    int res = 0;

    public void backTracking(int[] nums, int target, int index, int count) {
        if (index == nums.length) {
            if (target == count) res++;

            return;
        }

        backTracking(nums, target, index + 1, count + nums[index]);
        backTracking(nums, target, index + 1, count - nums[index]);
    }

    public int findTargetSumWays(int[] nums, int target) {
        backTracking(nums, target, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};

        var main = new Main();

        System.out.println(main.findTargetSumWays(nums, 1));
    }
}