public class Main {
    public boolean doesValidArrayExist(int[] derived) {
        int expectA = 0;
        int expectB = 1;

        for (int i = 0; i < derived.length; i++) {
            expectA ^= derived[i];
            expectB ^= derived[i];
        }

        return expectA == 0 && expectB == 1;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] derived = {1,1,0};

        System.out.println(main.doesValidArrayExist(derived));
    }
}