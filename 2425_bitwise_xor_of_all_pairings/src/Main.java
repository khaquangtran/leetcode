import java.util.Arrays;

public class Main {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int xor1 = 0, xor2 = 0;

        for (int n : nums2) xor2 ^= n;

        if (n2 % 2 != 0) {
            for (int n : nums1) {
                xor1 ^= n;
            }
        }

        System.out.println(xor1 ^ xor2);

        if (n1 % 2 != 0) xor1 ^= xor2;

        return xor1;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] nums1 = {27,6,15};
        int[] nums2 = {8,23,15,16,25,5};

        System.out.println(main.xorAllNums(nums1, nums2));
    }
}