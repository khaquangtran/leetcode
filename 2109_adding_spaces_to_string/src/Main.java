// https://leetcode.com/problems/adding-spaces-to-a-string/description/?envType=daily-question&envId=2024-12-03
public class Main {
    public static String solve(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && spaces[j] == i) {
                sb.append(' ');
                j++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};

        String res = solve(s, spaces);
        System.out.println(res);
    }
}