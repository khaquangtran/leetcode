public class Main {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (nums[low] < target) {
            return low + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] nums = {1,3,5,6};
        int target = 2;

        System.out.println(main.searchInsert(nums, target));
    }
}