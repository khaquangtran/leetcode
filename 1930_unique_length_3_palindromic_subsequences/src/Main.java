import java.util.Arrays;
import java.util.HashSet;

public class Main {
    private int preComputeFirstAndLastCharIndices(String s) {
        int[] frontIndexes = new int[26];
        int[] backIndexes = new int[26];

        Arrays.fill(frontIndexes, -1);
        Arrays.fill(backIndexes, -1);

        for (int i = 0; i < s.length(); i++) {
            int lastIndex = s.length() - 1 - i;

            int increasingCharIndex = s.charAt(i) - 'a';
            int decreasingCharIndex = s.charAt(lastIndex) - 'a';

            frontIndexes[decreasingCharIndex] = lastIndex;
            backIndexes[increasingCharIndex] = i;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            int frontIndex = frontIndexes[i];
            int backIndex = backIndexes[i];

            if (frontIndex != -1 && backIndex != -1 && backIndex - frontIndex >= 2) {
                HashSet<Character> hashSet = new HashSet<>();

                int low = frontIndex + 1;
                int high = backIndex - 1;

                while (low <= high) {
                    hashSet.add(s.charAt(low));
                    hashSet.add(s.charAt(high));

                    low++;
                    high--;
                }

                count += hashSet.size();
            }
        }

        return count;
    }

    public int countPalindromicSubsequence(String s) {
        return preComputeFirstAndLastCharIndices(s);
    }

    public static void main(String[] args) {
        Main main = new Main();
        String s = "bbcbaba";
        System.out.println(main.countPalindromicSubsequence(s));
    }
}