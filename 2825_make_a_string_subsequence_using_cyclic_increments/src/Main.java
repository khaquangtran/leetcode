// url: https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments
public class Main {
    public static boolean solve(String str1, String str2) {
        int i = 0, j = 0, len1 = str1.length(), len2 = str2.length();

        while (i < len1 && j < len2) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);

            // check if 2 chars are same/next char are same
            if (c1 == c2 || (char)(c1 + 1) == c2 || (c1 == 'z' && 'a' == c2)) {
                j++;
            }

            i++;
        }

        return j == len2;
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bcd";
        System.out.println(solve(str1, str2));
    }
}