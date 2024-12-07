import java.util.Arrays;

public class Main {

    private static boolean canDivide(int[] nums, int max, int maxOperations) {
        int ops = 0;
        for (int n: nums) {
            ops += (n - 1 + max) / max - 1;
            if (ops > maxOperations) return false;
        }

        return true;
    }

    public int minimumSize2(int[] nums, int maxOperations) {
         int low = 1, high = Arrays.stream(nums).max().getAsInt();

         while (low < high) {
             int mid = (low + high) / 2;

             int ops = 0;

             for (int num: nums) {
                 ops += (num - 1) / mid;
             }

             if (ops <= maxOperations) high = mid;
             else low = mid + 1;
         }

         return high;
    }

    private static int minimumSize(int[] nums, int maxOperations) {

        int left = 1, right = Arrays.stream(nums).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;

            if (canDivide(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,4,5,6,6,2,3,4};

        int maxOperations = 4;

        System.out.println(minimumSize(nums, maxOperations));
    }
}