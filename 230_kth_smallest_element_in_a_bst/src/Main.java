public class Main {
    int kthSmallest = Integer.MIN_VALUE;
    int kth = 0;

    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) return;

        inorderTraversal(node.left, k);

        kth++;

        if (kth == k) {
            kthSmallest = node.val;
        }

        inorderTraversal(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return kthSmallest;
    }

    public static void main(String[] args) {
    }
}