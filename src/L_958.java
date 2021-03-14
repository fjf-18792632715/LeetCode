import javafx.scene.transform.Rotate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

public class L_958 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        // 二叉树的完全性检验（是否是一个完全二叉树）
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) return true;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            root.val = 1;
            int index = 1;

            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp.val == index) {
                    if (temp.left != null) {
                        temp.left.val = temp.val * 2;
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        temp.right.val = temp.val * 2 + 1;
                        queue.offer(temp.right);
                    }
                    index++;
                } else return false;
            }

            return true;
        }
    }

}
