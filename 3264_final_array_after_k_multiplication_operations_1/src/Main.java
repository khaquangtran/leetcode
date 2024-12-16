import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                boolean isSame = o1[1] == o2[1];

                if (isSame) {
                    if (o1[0] > o2[0]) {
                        return 1;
                    }

                    return -1;
                } else {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] < o2[1]) {
                        return -1;
                    }

                    return 0;
                }
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{i, nums[i]});
        }

        while (k-- > 0) {
            int[] num = pq.poll();
            num[1] *= multiplier;
            pq.offer(num);
        }

        while (!pq.isEmpty()) {
            int[] num = pq.poll();
            nums[num[0]] = num[1];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        int k = 5;
        int multiplier = 2;

        System.out.println(getFinalState(nums, k, multiplier));
    }
}