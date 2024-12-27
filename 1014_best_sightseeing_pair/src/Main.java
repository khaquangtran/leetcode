public class Main {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int maxLeft = values[0];

        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, maxLeft + values[i] - i);
            maxLeft = Math.max(maxLeft, values[i] + i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {54,31,48,44,96,99,20,51,54,18,85,25,84,91,48,40,72,22,9,30,87,7,39,87,19,23,40,59,7,10,6,3,7,59,20,40,86,18,43,78,83,95,27,25,80,96,29,21,49,18,62,100};

        Main main = new Main();
        System.out.println(main.maxScoreSightseeingPair(nums));
    }
}