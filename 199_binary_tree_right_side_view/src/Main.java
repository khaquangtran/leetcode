import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Main {
    int maxDepth = 0;
    List<Integer> list = new ArrayList<>();

    private void depthFirstSearch(TreeNode node, int depth) {
        if (node == null) {return null;}

        if (maxDepth < depth) {
            list.add(node.val);
            maxDepth = depth;
        }

        depthFirstSearch(node.right, depth + 1);
        depthFirstSearch(node.left, depth + 1);
    }

    private List<Integer> breadthFirstSearch(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                list.add(node.val);

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (i == 0) {
                    list.add(node.val);
                }
            }
        }

        return list;
    }

    public List<Integer> rightSideView(TreeNode root) {
        // return breadthFirstSearch(root);
        depthFirstSearch(root, 1);
        return list;
    }

    public static void main(String[] args) {
    }
}