class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int val) {
        this.val = val;
    }
}

public class Main {
    private static void traverseDFS(
            TreeNode leftChild,
            TreeNode rightChild,
            int level
    ) {
        if (leftChild == null || rightChild == null) {
            return;
        }

        if (level % 2 == 0) {
            int temp = leftChild.val;
            leftChild.val = rightChild.val;
            rightChild.val = temp;
        }

        traverseDFS(leftChild.left, rightChild.right, level + 1);
        traverseDFS(leftChild.right, rightChild.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        traverseDFS(root.left, root.right, 0);
    }
}