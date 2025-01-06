public class Main {
    public int[] minOperations(String boxes) {
        int ones = 0;
        int[] answer = new int[boxes.length()];

        int increment = 0;

        for (int i = 0; i < boxes.length(); i++) {
            increment += ones;

            answer[i] += increment;

            if (boxes.charAt(i) == '1') ones++;
        }

        increment = 0;
        ones = 0;

        for (int i = boxes.length() - 1; i >= 0; i--) {
            increment += ones;

            answer[i] += increment;

            if (boxes.charAt(i) == '1') ones++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();

        String boxes = "110";

        int[] answer = main.minOperations(boxes);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}