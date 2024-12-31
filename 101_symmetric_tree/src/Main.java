class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

public class Main {
    public boolean validatingByRecursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && validatingByRecursion(left.left, right.right) && validatingByRecursion(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return validatingByRecursion(root.left, root.right);
    }

    public static void main(String[] args) {

    }
}