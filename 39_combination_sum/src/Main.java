import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<List<Integer>> ans = new ArrayList<>();

    private void backTracking(int[] candidates, int target, List<Integer> baseList, int sum, int j) {
        if (sum == target) {
            ans.add(baseList);
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = j; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>(baseList);
            list.add(candidates[i]);
            backTracking(candidates, target, list, sum + candidates[i], i);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, new ArrayList<>(), 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> ans = main.combinationSum(candidates, target);

        for (List<Integer> list : ans) {
            for (int l: list) {
                System.out.printf("%4d", l);
            }

            System.out.println();
        }
    }
}
