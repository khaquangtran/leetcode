public class Main {
    public String shiftingLetters(String s, int[] shifts) {
        shifts[shifts.length - 1] %= 26;

        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }

        char[] charArray = s.toCharArray();

        for (int i = charArray.length - 1; i >= 0; i--) {
            int charIndex = charArray[i] - 'a';
            int destinCharIndex = (charIndex + shifts[i]) % 26;
            charArray[i] = (char)(destinCharIndex + 'a');
        }

        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Main main = new Main();

        String s = "abcd";
        int[] shifts = {100, 200, 300, 400};
        System.out.println(main.shiftingLetters(s, shifts));
    }
}