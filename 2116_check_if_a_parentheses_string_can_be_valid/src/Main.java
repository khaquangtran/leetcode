import java.util.Stack;

public class Main {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        int zeros = 0;
        int closes = 0;

        Stack<Integer> zeroIndexes = new Stack<>();
        Stack<Integer> closeIndexes = new Stack<>();

        for (int i = 0; i < locked.length(); i++) {
            if (locked.charAt(i) == '0') {
                zeroIndexes.push(i);
                zeros++;
                continue;
            }


            if (s.charAt(i) == '(') {
                closeIndexes.push(i);
                closes++;
            }
            else {
                if (closes > 0) {
                    closeIndexes.pop();
                    closes--;
                }
                else {
                    if (zeros > 0) {
                        zeroIndexes.pop();
                        zeros--;
                    }
                    else return false;
                }
            }
        }

        while (!closeIndexes.isEmpty() && !zeroIndexes.isEmpty()) {
            int closeIndex = closeIndexes.pop();
            int zeroIndex = zeroIndexes.pop();

            System.out.println(closeIndex + " " + zeroIndex);

            if (closeIndex > zeroIndex) {
                return false;
            }

            closes--;
            zeros--;
        }

        return closes == 0 && zeros % 2 == 0;
    }

    public static void main(String[] args) {
        Main main = new Main();

        String s = "())()))()(()(((())(()()))))((((()())(())";
        String locked = "1011101100010001001011000000110010100101";
//        String s = "()()";
//        String locked = "1010";

        System.out.println(main.canBeValid(s, locked));
    }
}