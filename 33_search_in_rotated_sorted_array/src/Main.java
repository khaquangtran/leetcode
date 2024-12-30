/**
 * 6 7 0 1 2 3 4 5  | target: 0, 2, 6
 * l     m       r
 * --------------------
 * l > r
 *  m < r
 *      target > l: r = m - 1
 *      target > m: l = m + 1
 *      target < m: r = m - 1
 * ---------------------
 * 3 4 5 6 7 8 9 0 1 2  | target: 6, 9, 1
 * l         m       r
 * ---------------------
 * l > r
 *  m > r
 *     target < r: l = m + 1
 *     target > m: l = m + 1
 *     target < m: r = m - 1
 */


public class Main {
    private int findRotatedBinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (nums[l] > nums[r]) {
            int mid = l + (r - l) / 2;

            int numMid = nums[mid], numLeft = nums[l], numRight = nums[r];

            if (numMid == target) {
                return mid;
            } else if (numMid < numRight) {
                if (target >= numLeft || target <= numMid) {
                    r = mid - 1;
                } else if (target <= numRight) {
                    l = mid + 1;
                } else {
                    return -1;
                }
            } else if (numMid > numRight) {
                if (target <= numRight || target >= numMid) {
                    l = mid + 1;
                } else if (target >= numLeft) {
                    r = mid - 1;
                } else {
                    return -1;
                }
            }
        }

        System.out.println(l + " " + r);

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        return findRotatedBinarySearch(nums, target);
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] nums = {3, 1};

        System.out.println(main.search(nums, 0));
    }
}