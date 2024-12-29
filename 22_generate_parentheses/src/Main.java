import java.util.ArrayList;
import java.util.List;

public class Main {
    List<String> ans = new ArrayList<>();

    private void backTracking(String str, int n, int closeNeed, int openNeed) {
        StringBuilder sb = new StringBuilder(str);

        if (sb.length() == n * 2) {
            ans.add(sb.toString());
            return;
        }

        if (openNeed < n) {
            sb.append('(');
            backTracking(sb.toString(), n, closeNeed, openNeed + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeNeed < openNeed) {
            sb.append(')');
            backTracking(sb.toString(), n, closeNeed + 1, openNeed);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        backTracking("", n, 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();

        List<String> ans = main.generateParenthesis(3);

        for (String s : ans) {
            System.out.println(s);
        }
    }
}
