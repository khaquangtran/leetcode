import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public List<List<Integer>> breadthFirstSearch(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            levels.add(level);
        }

        return levels;
    }

    List<List<Integer>> levels = new ArrayList<>();

    public void depthFirstSearch(TreeNode node, int levelIndex) {
        if (node == null) return;

        if (levels.size() == levelIndex) {
            List<Integer> level = new ArrayList<>();
            level.add(node.val);
            levels.add(level);
        } else {
            levels.get(levelIndex).add(node.val);
        }

        depthFirstSearch(node.left, levelIndex + 1);
        depthFirstSearch(node.right, levelIndex + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
//        return breadthFirstSearch(root);
        depthFirstSearch(root, 0);
        return levels;
    }

    public static void main(String[] args) {
    }
}