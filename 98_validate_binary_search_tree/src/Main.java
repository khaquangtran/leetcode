import java.util.Stack;

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
    long comparer = Long.MIN_VALUE;
    boolean isBinarySearchTree = true;

    private boolean validatingByIteration(TreeNode node) {
        if (node == null) return false;

        long comparer = Long.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();

            if (n.left != null || n.right != null) {
                TreeNode nr = n.right, nl = n.left;

                if (nr != null) stack.push(nr);

                n.left = null;
                n.right = null;
                stack.push(n);

                if (nl != null) stack.push(nl);
            } else {
                if (n.val > comparer) {
                    comparer = n.val;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private void validatingByRecursion(TreeNode node) {
        if (node == null) return;

        validatingByRecursion(node.left);

        if (node.val > comparer) {
            comparer = node.val;
        }
        else {
            isBinarySearchTree = false;
            return;
        }

        validatingByRecursion(node.right);
    }

    public boolean isValidBST(TreeNode root) {
        // validatingByRecursion(root);
        // return isBinarySearchTree;
        return validatingByIteration(root);
    }

    public static void main(String[] args) {
        Main main = new Main();


    }
}