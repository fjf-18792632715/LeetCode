import javax.print.attribute.standard.OrientationRequested;
import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

public class L_897 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            TreeNode head = new TreeNode(-1);
            TreeNode preNode = head;
            if (root == null) return null;
            Deque<TreeNode> stack = new LinkedList<>();

            TreeNode curNode = root;
            while (curNode != null || !stack.isEmpty()) {
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }

                curNode = stack.pop();
                // 处理节点
                preNode.right = curNode;
                preNode = curNode;

                curNode = curNode.right;
            }

            return head.right;
        }
    }

}
