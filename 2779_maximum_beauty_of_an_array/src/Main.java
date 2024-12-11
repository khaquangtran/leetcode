import java.util.Arrays;

public class Main {
    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = 0;

        int ans = 0;

        while (right < nums.length) {
            while (nums[right] - k > nums[left] + k) {
                left++;
            }

            ans = Math.max(ans, right - left + 1);

            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,1,2};
        int k = 2;
        System.out.println(maximumBeauty(nums, k));
    }
}