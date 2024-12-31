public class Main {
    int maxDepth = 0;

    public void depthFirstSearch(TreeNode node, int depth) {
        if (node == null) return;

        maxDepth = Math.max(maxDepth, depth);

        depthFirstSearch(node.left, depth + 1);
        depthFirstSearch(node.right, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        depthFirstSearch(root, 1);
        return maxDepth;
    }

    public static void main(String[] args) {

    }
}