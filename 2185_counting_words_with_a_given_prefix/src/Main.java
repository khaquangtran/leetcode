public class Main {
    private int bruteForce(String[] words, String pref) {
        int count = 0;

        for (String word : words) {
            if (word.startsWith(pref)) count++;
        }

        return count;
    }

    public int prefixCount(String[] words, String pref) {
        return bruteForce(words, pref);
    }

    public static void main(String[] args) {
        Main main = new Main();

        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";

        System.out.println(main.prefixCount(words, pref));
    }
}