import java.util.ArrayList;
import java.util.List;

public class Main {
    List<List<String>> partitions = new ArrayList<>();

    private boolean isPalindrome(StringBuilder builder) {
        int l = 0, r = builder.length() - 1;

        while (l < r) {
            if (builder.charAt(l++) != builder.charAt(r--)) {
                return false;
            }
        }

        return true;
    }

    private boolean isListAllPalindrome(List<StringBuilder> list) {
        boolean isValid = true;

        for (StringBuilder builder : list) {
            isValid &= isPalindrome(builder);
        }

        return isValid;
    }

    private void backTracking(String s, int index, List<StringBuilder> p) {
        if (index == s.length()) {
            if (isListAllPalindrome(p)) {
                partitions.add(p.stream().map(StringBuilder::toString).toList());
            }

            return;
        }

        p.add(new StringBuilder(Character.toString(s.charAt(index))));
        backTracking(s, index + 1, p);
        p.removeLast();

        p.getLast().append(s.charAt(index));
        backTracking(s, index + 1, p);
        p.getLast().deleteCharAt(p.getLast().length() - 1);
    }

    public List<List<String>> partition(String s) {
        List<StringBuilder> p = new ArrayList<>();
        p.add(new StringBuilder(Character.toString(s.charAt(0))));
        backTracking(s, 1, p);
        return partitions;
    }

    public static void main(String[] args) {
        String s = "aab";

        Main main = new Main();

        List<List<String>> partitions = main.partition(s);

        for (List<String> partition : partitions) {
            for (String p : partition) {
                System.out.println(p);
            }
            System.out.println();
        }
    }
}