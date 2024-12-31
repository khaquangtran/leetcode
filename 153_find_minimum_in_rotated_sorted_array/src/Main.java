public class Main {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        if (nums[low] < nums[high]) return 0;

        while (low < high) {
            int mid = (low + high) / 2;

            int midValue = nums[mid], lowValue = nums[low], highValue = nums[high];

            if (midValue > highValue) {
                low = mid + 1;
            } else if (midValue < highValue) {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] nums = {4,5,0,1,2,3};
        System.out.println(main.findMin(nums));
    }
}