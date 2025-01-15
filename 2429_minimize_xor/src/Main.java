public class Main {
    public int minimizeXor(int num1, int num2) {
        int result = 0;

        int bitsCount = Integer.bitCount(num2);
        int bitTook = 0;
        int currentBit = 31;

        while (bitTook < bitsCount) {
            if (isBitPresent(num1, currentBit) || (bitsCount - bitTook > currentBit)) {
                result = getBit(result, currentBit);
                bitTook++;
            }
            currentBit--;
        }

        return result;
    }

    private boolean isBitPresent(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    private int getBit(int x, int bit) {
        return x | (1 << bit);
    }

    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.minimizeXor(5, 5));
    }
}