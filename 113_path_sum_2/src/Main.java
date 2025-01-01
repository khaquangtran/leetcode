import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Main {
    List<List<Integer>> paths = new ArrayList<>();

    private void depthFirstTraversal(TreeNode root, int targetSum, int sum, List<Integer> path) {
        if (root == null) return;

        int s = sum + root.val;
        path.add(root.val);

        // this is a leaf node
        if (root.left == null && root.right == null) {
            if (s == targetSum) {
                paths.add(new ArrayList<>(path));
            }
            return;
        }

        depthFirstTraversal(root.left, targetSum, s, path);
        depthFirstTraversal(root.right, targetSum, s, path);

        System.out.println(path.getLast());
        path.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return paths;
        }

        depthFirstTraversal(root, targetSum, 0, new ArrayList<>());

        return paths;
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}