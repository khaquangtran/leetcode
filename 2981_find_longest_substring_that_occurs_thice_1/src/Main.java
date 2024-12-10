public class Main {
    public static int maximumLength(String s) {
        char[] chars = s.toCharArray();

        int ans = -1, low = 1, high = chars.length - 2;

        while (low <= high) {
            int mid =  (low + high) / 2;

            if (isValid(chars, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private static boolean isValid(char[] chars, int target) {
        int[] counts = new int[26];

        int left = 0, right = 0, len = chars.length;

        while (right < len) {
            if (chars[right] != chars[left]) {
                left = right;
            }

            if (right - left + 1 == target) {
                counts[chars[right] - 'a']++;
                left++;
            }

            if (counts[chars[right] - 'a'] > 2) return true;

            right++;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "abcdef";

        System.out.println(maximumLength(s));
    }
}