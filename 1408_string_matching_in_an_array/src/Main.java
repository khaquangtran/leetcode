import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<String> bruteForce(String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            String word = words[i];

            for (int j = 0; j < n; j++) {

                if (i == j) continue;

                String comparedWord = words[j];
                if (comparedWord.contains(word)) {
                    result.add(word);
                    break;
                }
            }
        }

        return result;
    }

    public List<String> stringMatching(String[] words) {
        return bruteForce(words);
    }

    public static void main(String[] args) {
        Main main = new Main();

        String[] words = {"leetcoder","leetcode","od","hamlet","am"};

        List<String> matchings = main.stringMatching(words);

        for (String matching : matchings) {
            System.out.println(matching);
        }
    }
}