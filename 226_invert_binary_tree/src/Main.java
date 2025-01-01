class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    private TreeNode invertByRecursion(TreeNode node) {
        if (node == null) return null;

        TreeNode leftNode = node.left, rightNode = node.right;

        node.left = rightNode;
        node.right = leftNode;

        invertByRecursion(node.left);
        invertByRecursion(node.right);

        return node;
    }

    public TreeNode invertTree(TreeNode root) {
        return invertByRecursion(root);
    }

    public static void main(String[] args) {

    }
}