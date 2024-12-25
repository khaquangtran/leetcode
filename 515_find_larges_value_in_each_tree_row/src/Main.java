import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void depthFirstSearch(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;

        if (res.size() == level) {
            res.add(node.val);
        } else {
            res.set(level, Math.max(node.val, res.get(level)));
        }

        depthFirstSearch(node.left, level + 1, res);
        depthFirstSearch(node.right, level + 1, res);
    }

    public static List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> ans = new LinkedList<>();

        depthFirstSearch(root, 0, ans);
        return ans;
    }

    public static List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                maxVal = Math.max(maxVal, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(maxVal);
        }

        return res;
    }

    public static void main(String[] args) {
        Integer[] inputs = {1,3,2,5,3,null,9};

        TreeNode root = new TreeNode(inputs[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (index < inputs.length && inputs[index] != null) {
                    node.left = new TreeNode(inputs[index]);
                    queue.add(node.left);
                }

                if (index + 1 < inputs.length && inputs[index + 1] != null) {
                    node.right = new TreeNode(inputs[index + 1]);
                    queue.add(node.right);
                }

                index += 2;
            }
        }

        List<Integer> res = largestValuesDFS(root);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}