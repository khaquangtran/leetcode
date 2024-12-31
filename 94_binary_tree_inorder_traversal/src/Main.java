import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
    List<Integer> links = new ArrayList<>();

    public void inorderTraversalRecursive(TreeNode node) {
        if (node == null) return;

        inorderTraversalRecursive(node.left);

        links.add(node.val);

        inorderTraversalRecursive(node.right);
    }

    public void inorderTraversalIterative(TreeNode node) {
        if (node == null) return;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();

            TreeNode nr = n.right, nl = n.left;

            if (nr != null || nl != null) {
                if (nr != null) stack.push(nr);

                n.left = null;
                n.right = null;
                stack.push(n);

                if (nl != null) stack.push(nl);
            } else {
                links.add(n.val);
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // inorderTraversalRecursive(root);
        inorderTraversalIterative(root);
        return links;
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}