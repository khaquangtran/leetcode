class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Main {
    private TreeNode findLowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || p == node || q == node) return node;

        TreeNode leftNode = findLowestCommonAncestor(node.left, p, q);
        TreeNode rightNode = findLowestCommonAncestor(node.right, p, q);

        // if both branches are defined -> both p & q are found
        if (leftNode != null && rightNode != null) return node;
        else if (leftNode != null) return leftNode;
        else if (rightNode != null) return rightNode;

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestCommonAncestor(root, p, q);
    }

    public static void main(String[] args) {
    }
}