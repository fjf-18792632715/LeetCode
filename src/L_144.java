import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/*
        注意： push操作是头插， offer操作是尾插
 */
public class L_144 {

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.offer(1);
        stack.offer(7);
        stack.offer(3);
        for (Integer integer : stack) {
            System.out.println(integer);
        }

        Deque<Integer> stack1 = new LinkedList<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        for (Integer integer : stack1) {
            System.out.println(integer);
        }
    }

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

    // 迭代的二叉树前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.offer(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            System.out.println(res);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);


        }

        return res;

    }
}
