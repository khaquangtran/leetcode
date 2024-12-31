public class Main {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


        if (r < 0 || nums[r] != target) {
            return new int[]{-1, -1};
        }

        int l1 = r, r1 = nums.length - 1;

        while (l1 < r1) {
            int mid = (int)Math.ceil(l1 + ((double)r1 - l1) / 2.);

            if (nums[mid] == target) {
                l1 = mid;
            } else {
                r1 = mid - 1;
            }
        }

        return new int[] {r, l1};
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1,2,4,4,4,5,6,7,8};
        int target = 4;

        int[] ans = main.searchRange(nums, target);

        System.out.printf("[%d,%d]", ans[0], ans[1]);
    }
}