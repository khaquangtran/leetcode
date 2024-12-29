import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public List<List<Integer>> ans = new ArrayList<>();

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void advancedBackTracking(int[] nums, int idx) {
        if (idx == nums.length) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            advancedBackTracking(nums, idx + 1);
            swap(nums, idx, i);
        }
    }

    private void backTracking(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int num: nums) {
            if (!list.contains(num)) {
                list.add(num);
                backTracking(nums, list);
                list.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        advancedBackTracking(nums, 0);
        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] nums = {1, 2, 3};

        List<List<Integer>> lists = main.permute(nums);

        for (List<Integer> list : lists) {
            for (int i: list) {
                System.out.printf("%4d", i);
            }
            System.out.println();
        }
    }
}