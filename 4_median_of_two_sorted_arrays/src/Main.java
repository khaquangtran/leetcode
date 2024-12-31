public class Main {
    private int binarySearch(int[] nums1, int nums1Start, int nums1End, int[] nums2, int nums2Start, int nums2End, int mid) {
        if (nums1Start > nums1End) {
            return nums2[mid - nums1Start];
        } else if (nums2Start > nums2End) {
            return nums1[mid - nums2Start];
        }

        int nums1MidIndex = (nums1Start + nums1End) / 2;
        int nums2MidIndex = (nums2Start + nums2End) / 2;

        int nums1MidValue = nums1[nums1MidIndex];
        int nums2MidValue = nums2[nums2MidIndex];

        if (nums1MidIndex + nums2MidIndex < mid) {
            if (nums1MidValue <= nums2MidValue) {
                return binarySearch(nums1, nums1MidIndex + 1, nums1End, nums2, nums2Start, nums2End, mid);
            } else {
                return binarySearch(nums1, nums1Start, nums1End, nums2, nums2MidIndex + 1, nums2End, mid);
            }
        } else {
            if (nums1MidValue <= nums2MidValue) {
                return binarySearch(nums1, nums1Start, nums1End, nums2, nums2Start, nums2MidIndex - 1, mid);
            } else {
                return binarySearch(nums1, nums1Start, nums1MidIndex - 1, nums2, nums2Start, nums2End, mid);
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length, nums2Length = nums2.length;
        int mid = (nums1Length + nums2Length) / 2;

        boolean isOdd = ((nums1Length + nums2Length) % 2) == 1;

        if (isOdd) {
            return binarySearch(nums1, 0, nums1Length - 1, nums2, 0, nums2Length - 1, mid);
        } else {
            return (binarySearch(nums1, 0, nums1Length - 1, nums2, 0, nums2Length - 1, mid) +
                    binarySearch(nums1, 0, nums1Length - 1, nums2, 0, nums2Length - 1, mid - 1)) / 2.;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1,1,2,2,3,3,4,4,5,5};

        System.out.println(main.findMedianSortedArrays(nums1, nums2));
    }
}