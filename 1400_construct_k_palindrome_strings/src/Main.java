public class Main {
    private boolean bitMask(String s, int k) {
        if (s.length() < k) return false;
        else if (s.length() == k) return true;

        int odds = 0;

        for (int i = 0; i < s.length(); i++) {
            odds ^= 1 << (s.charAt(i) - 'a');
        }

        return Integer.bitCount(odds) <= k;
    }

    private boolean bruteForce(String s, int k) {
        if (s.length() < k) return false;
        else if (s.length() == k) return true;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int odds = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) odds++;
        }

        return odds <= k;
    }

    public boolean canConstruct(String s, int k) {
        return bitMask(s, k);
    }

    public static void main(String[] args) {
        Main main = new Main();

        String s = "annabelle";
        int k = 3;

        System.out.println(main.canConstruct(s, k));
    }
}