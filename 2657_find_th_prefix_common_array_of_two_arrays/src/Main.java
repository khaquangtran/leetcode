public class Main {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        boolean[] mem = new boolean[n + 1];
        int[] C = new int[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (mem[A[i]]) count++;
            mem[A[i]] = true;

            if (mem[B[i]]) count++;
            mem[B[i]] = true;

            C[i] = count;
        }

        return C;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] A = {2,3,1};
        int[] B = {3,1,2};

        int[] common = main.findThePrefixCommonArray(A, B);

        for (int c : common) {
            System.out.print(c + " ");
        }
    }
}