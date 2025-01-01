class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Main {
    int count = 0;

    private void countTraversal(TreeNode node, int remaining) {
        if (node == null) return;

        int subtraction = (remaining - node.val) % (int)(1e9 + 7);

        if (subtraction == 0) {
            count++;
            return;
        }

        countTraversal(node.left, subtraction);
        countTraversal(node.right, subtraction);
    }

    private void depthFirstTraversal(TreeNode node, int targetSum) {
        if (node == null) return;

        countTraversal(node, targetSum);
        depthFirstTraversal(node.left, targetSum);
        depthFirstTraversal(node.right, targetSum);
    }

    public int pathSum(TreeNode root, int targetSum) {
        depthFirstTraversal(root, targetSum);
        return count;
    }

    public static void main(String[] args) {
    }
}