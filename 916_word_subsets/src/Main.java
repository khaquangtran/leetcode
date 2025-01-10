import java.util.ArrayList;
import java.util.List;

public class Main {
    private int[] getFrequencies(String word) {
        int[] freq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        return freq;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] words2Freq = getFrequencies("");

        for (String word : words2) {
            int[] freq = getFrequencies(word);

            for (int i = 0; i < 26; i++) {
                words2Freq[i] = Math.max(words2Freq[i], freq[i]);
            }
        }

        search: for (String word : words1) {
            int[] freq = getFrequencies(word);

            for (int i = 0; i < 26; i++) {
                if (freq[i] < words2Freq[i]) {
                    continue search;
                }
            }

            res.add(word);
        }

        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();

        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e", "o"};

        List<String> subsets = main.wordSubsets(words1, words2);

        for (String s : subsets) {
            System.out.println(s);
        }
    }
}