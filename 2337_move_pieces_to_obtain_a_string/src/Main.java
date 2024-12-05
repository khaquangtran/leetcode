public class Main {
    private static void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    private static boolean canChangeBetter(String s, String t) {
        char[] start = s.toCharArray();
        char[] target = t.toCharArray();

        int i = 0, j = 0, l = s.length();

        while (i <= l && j <= l) {

            while (i < l && start[i] == '_') i++;
            while (j < l && target[j] == '_') j++;


            if (i == l || j == l) return i == l && j == l;

            if (start[i] != target[j]) return false;
            if (i < j && start[i] == 'L') return false;
            if (i > j && start[i] == 'R') return false;

            i++;
            j++;
        }

        return true;
    }

    private static boolean canChange(String s, String t) {
        StringBuilder start = new StringBuilder(s);
        StringBuilder target = new StringBuilder(t);

        int l = s.length();
        int right = 0, left = l - 1;

        for (int i = 0; i < l; i++) {
            if (target.charAt(i) == 'L') {
                for (int j = Math.max(right, i); j < l; j++) {
                    char c = start.charAt(j);
                    if (c == 'R') return false;

                    if (c == 'L') {
                        swap(start, i, j);
                        right = j + 1;
                        break;
                    }
                }
            }
        }

        for (int i = l - 1; i >= 0; i--) {
            if (target.charAt(i) == 'R') {
                for (int j = Math.min(left, i); j >= 0; j--) {
                    char c = start.charAt(j);

                    if (c == 'L') return false;

                    if (c == 'R') {
                        swap(start, i, j);
                        left = j - 1;
                        break;
                    }
                }
            }
        }

        return start.toString().equals(target.toString());
    }

    public static void main(String[] args) {
        String start = "_L__R__R_";
        String target = "L______RR";

        System.out.println(canChange(start, target));
    }
}