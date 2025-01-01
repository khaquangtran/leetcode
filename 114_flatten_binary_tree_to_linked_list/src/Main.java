import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

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
    private TreeNode flattenToLinkedListByIteration(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode head = new TreeNode();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node == null) continue;

            TreeNode leftNode = node.left; TreeNode rightNode = node.right;

            stack.push(rightNode);
            stack.push(leftNode);

            node.left = null;
            node.right = null;

            head.right = node;
            head = head.right;
        }

        return root;
    }

    public void flatten(TreeNode root) {
        flattenToLinkedListByIteration(root);
    }

    public static void main(String[] args) {}
}