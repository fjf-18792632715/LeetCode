import java.util.Deque;
import java.util.LinkedList;

public class L_617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) return t2;
            if (t2 == null) return t1;

            method(t1, t2);

            return t1;
        }

        public void method(TreeNode t1, TreeNode t2) {

            t1.val = t1.val + t2.val;
            if (t1.left != null && t2.left != null) {
                method(t1.left, t2.left);
            } else if (t1.left == null && t2.left != null) {
                t1.left = t2.left;
            }

            if (t1.right != null && t2.right != null) {
                method(t1.right, t2.right);
            } else if (t1.right == null && t2.right != null) {
                t1.right = t2.right;
            }
        }
    }

}
