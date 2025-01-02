import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    HashSet<Character> hashSet = new HashSet<>(Arrays.asList('a', 'e', 'u', 'i', 'o'));

    private int[] prefixSum(String[] words, int[][] queries) {

        int[] prefixSum = new int[words.length];

        int sum = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (hashSet.contains(word.charAt(0)) && hashSet.contains(word.charAt(word.length() - 1))) {
                sum++;
            }

            prefixSum[i] = sum;
        }


        int[] ranges = new int[queries.length];
        // a e i
        // 1 2 3

        // 0 - 2: 3
        // 0 - 1: 2
        // 2 - 2:

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            ranges[i] = prefixSum[query[1]] - (query[0] == 0 ? 0 : prefixSum[query[0] - 1]);
        }

        return ranges;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        return prefixSum(words, queries);
    }

    public static void main(String[] args) {
        Main main = new Main();

        String[] words = {"a", "e", "i"};
        int[][] queries = {
                {0, 2},
                {0, 1},
                {2, 2}
        };

        int[] ranges = main.vowelStrings(words, queries);

        for (int range: ranges) {
            System.out.println(range);
        }
    }
}