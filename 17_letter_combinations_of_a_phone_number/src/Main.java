import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    List<String> ans = new ArrayList<>();
    Map<Character, String> hashMap = new HashMap<>();

    private void backTracking(String digits, int curIdx, StringBuilder baseSB) {
        if (curIdx == digits.length()) {
            ans.add(baseSB.toString());
            return;
        }

        char d = digits.charAt(curIdx);
        StringBuilder sb = new StringBuilder(baseSB);

        for (char c: hashMap.get(d).toCharArray()) {
            sb.append(c);

            backTracking(digits, curIdx + 1, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return ans;

        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        backTracking(digits, 0, new StringBuilder());

        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<String> ans = main.letterCombinations("23");

        for (String s : ans) {
            System.out.println(s);
        }
    }
}
