class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Main {
    int maxDiameter = 0;

    private int depthFirstTraversal(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depthFirstTraversal(node.left);
        int rightDepth = depthFirstTraversal(node.right);

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depthFirstTraversal(root);
        return maxDiameter;
    }

    public static void main(String[] args) {

    }
}