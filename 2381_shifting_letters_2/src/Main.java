public class Main {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();

        int[] prefixSum = new int[n];

        for (int[] shift : shifts) {
            int low = shift[0];
            int high = shift[1];
            int direction = shift[2];

            if (direction == 1) {
                prefixSum[low]++;

                if (high + 1 < n) {
                    prefixSum[high + 1]--;
                }
            } else {
                prefixSum[low]--;

                if (high + 1 < n) {
                    prefixSum[high + 1]++;
                }
            }
        }

        int targetIndex = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int charIndex = charArray[i] - 'a';
            targetIndex = (targetIndex + prefixSum[i]) % 26;

            int targetCharIndex = (charIndex + targetIndex) % 26;

            if (targetCharIndex < 0) targetCharIndex += 26;

            charArray[i] = (char)(targetCharIndex + 'a');
        }

        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Main main = new Main();

        String s = "abc";
        int[][] shifts = {
                {0,1,0},
                {1,2,0},
                {0,2,0}
        };

        System.out.println(main.shiftingLetters(s, shifts));
    }
}