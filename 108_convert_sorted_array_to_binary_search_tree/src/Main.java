import java.util.LinkedList;
import java.util.Queue;

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
    private TreeNode divineAndConquer(int[] nums, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }
        else if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        }

        int pivot = (startIndex + endIndex) / 2;

        TreeNode leftNode = divineAndConquer(nums, startIndex, pivot - 1);
        TreeNode rightNode = divineAndConquer(nums, pivot + 1, endIndex);

        return new TreeNode(nums[pivot], leftNode, rightNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return divineAndConquer(nums, 0, nums.length - 1);
    }

    private void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    System.out.printf("%d ", node.val);
                } else {
                    System.out.println("null");
                }

                if (node != null && (node.left != null || node.right != null)) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        TreeNode root = main.sortedArrayToBST(nums);
        main.printTree(root);
    }
}