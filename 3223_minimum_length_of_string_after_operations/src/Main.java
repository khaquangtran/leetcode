public class Main {
    public int minimumLength(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int res = 0;

        for (int f : freq) {
            if (f <= 2) {
                res += f;
                continue;
            }

            int remain = f % 2;

            if (remain == 0) remain = 2;

            res += remain;
        }

        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();

        String s = "abaacbcbb";

        System.out.println(main.minimumLength(s));
    }
}