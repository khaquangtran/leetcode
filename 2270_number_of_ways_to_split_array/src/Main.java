import java.util.Arrays;

public class Main {

    public int waysToSplitArray(int[] nums) {
        final int MODULO = (int)1e9 + 7;

        long leftSum = Arrays.stream(nums).sum();

        int validSplits = 0;
        long rightSum = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            leftSum -= num;
            rightSum += num;

            if (rightSum >= leftSum) {
                validSplits++;
            }
        }

        return validSplits;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {10, 4, -8, 7};
        System.out.println(main.waysToSplitArray(nums));
    }
}