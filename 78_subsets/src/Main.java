import java.util.ArrayList;
import java.util.List;

public class Main {
    List<List<Integer>> sss = new ArrayList<List<Integer>>();

    private void backTracking(List<Integer> subset, int[] nums, int idx) {
        sss.add(new ArrayList<>(subset));

        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);

            backTracking(subset, nums, i + 1);

            subset.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(new ArrayList<>(), nums, 0);
        return sss;
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<List<Integer>> sss =  main.subsets(new int[]{1, 2, 3});

        for (List<Integer> subset : sss) {
            for (Integer num : subset) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}