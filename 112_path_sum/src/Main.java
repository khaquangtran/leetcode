class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Main {
    boolean isValid = false;

    public void depthFirstSearch(TreeNode node, int targetSum, int sum, int level) {
        if (node == null) return;

        // is leaf node
        if (node.left == null && node.right == null) {
            if (targetSum == sum + node.val) {
                isValid = true;
            }

            return;
        }

        depthFirstSearch(node.left, targetSum, sum + node.val, level + 1);
        depthFirstSearch(node.right, targetSum, sum + node.val, level + 1);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        depthFirstSearch(root, targetSum, 0, 0);
        return isValid;
    }

    public static void main(String[] args) {
    }
}