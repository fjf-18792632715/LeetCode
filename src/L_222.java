import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class L_222 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 二分法
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = 0;
        TreeNode cur = root;
        while (cur != null) {
            cur = cur.left;
            h++;
        }

        return 0;

    }

    // bfs 层序遍历(11.47%)
    public int countNodes1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }

        }

        return count;
    }

}
