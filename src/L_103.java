
import java.util.*;

public class L_103 {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> deque = new LinkedList<>();
        if (root == null) return res;
        boolean flag = true;

        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            TreeNode temp;

            for (int i = 0; i < size; i++) {
                temp = deque.poll();
                if (temp.left != null) deque.offer(temp.left);
                if (temp.right != null) deque.offer(temp.right);
                if (flag) {
                    list.add(temp.val);
                } else {
                    list.add(0, temp.val);
                }
            }
            res.add(list);

            flag = !flag;
        }

        return res;
    }

}
