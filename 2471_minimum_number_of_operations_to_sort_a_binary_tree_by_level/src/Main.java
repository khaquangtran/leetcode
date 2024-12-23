import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Pair {
    int val;
    int originalIndex;

    Pair(int val, int originalIndex) {
        this.val = val;
        this.originalIndex = originalIndex;
    }
}

public class Main {
    public static int minimumOperations(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Pair[] nodes = new Pair[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                nodes[i] = new Pair(node.val, i);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            Arrays.sort(nodes, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o1.val < o2.val) {
                        return -1;
                    } else if (o1.val > o2.val) {
                        return 1;
                    }

                    return 0;
                }
            });

            for (int i = 0; i < nodes.length; i++) {
                System.out.println(nodes[i].val);
            }

            for (int i = 0; i < size; i++) {
                Pair node = nodes[i];

                if (i != node.originalIndex) {
                    nodes[i--] = nodes[node.originalIndex];
                    nodes[node.originalIndex] = node;
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(minimumOperations(root));
    }
}