import javax.tools.JavaCompiler;
import javax.xml.stream.FactoryConfigurationError;
import java.time.temporal.Temporal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class L_662 {
    public class TreeNode {
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


    // 使用节点的val存储节点的位置编号，类似于满二叉树编号
    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        root.val = 1;
        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = 0;
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == 0) left = temp.val;
                if (i == size - 1) right = temp.val;
                if (temp.left != null) {
                    temp.left.val = temp.val * 2;
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    temp.right.val = temp.val * 2 + 1;
                    queue.offer(temp.right);
                }
            }

            int width = right - left + 1;
            maxWidth = maxWidth > width ? maxWidth : width;
        }

        return maxWidth;
    }

    // 方法超时
    public int widthOfBinaryTree(TreeNode root) {
         if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(size);
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    flag = true;
                    queue.add(temp.left);
                    queue.add(temp.right);
                } else {
                    queue.add(null);
                    queue.add(null);
                }
            }
            if (flag) {
                maxWidth = maxWidth > size ? maxWidth : size;
            }
            while (!queue.isEmpty() && queue.peek() == null) queue.poll();
            while (!queue.isEmpty() && queue.peekLast() == null) {
                System.out.println(queue.removeLast());
            }
        }

        return maxWidth;
    }
}
