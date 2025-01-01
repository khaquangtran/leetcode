public class Main {
    public int maxScore(String s) {
        int zeros = 0, ones = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }

        int score = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);

            if (c == '0') {
                zeros++;
            } else {
                ones--;
            }

            score = Math.max(score, zeros + ones);
        }

        return score;
    }

    public static void main(String[] args) {
        Main main = new Main();

        String s = "11";
        System.out.println(main.maxScore(s));
    }
}