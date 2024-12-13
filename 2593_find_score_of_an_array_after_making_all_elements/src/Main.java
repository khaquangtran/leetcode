import java.util.*;

class Pair {
    public int value, index;

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int compareTo(Pair o) {
        if (this.value == o.value) {
            if (this.index < o.index) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.value < o.value) {
            return -1;
        } else {
            return 1;
        }
    }
}

public class Main {
    public static long findScore(int[] nums) {
        int len = nums.length;
        Pair[] pairs = new Pair[len];
        boolean[] marked = new boolean[len];

        for (int i = 0; i < len; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.compareTo(o2);
            }
        });

        long ans = 0;

        for (Pair pair : pairs) {
            if (!marked[pair.index]) {
                ans += pair.value;
                marked[pair.index] = true;
                marked[Math.max(0, pair.index - 1)] = true;
                marked[Math.min(pair.index + 1, len - 1)] = true;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,1,3,2};
        System.out.println(findScore(nums));
    }
}