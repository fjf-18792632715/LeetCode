import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 */

public class L_637 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {

    }

    // 层次优先遍历
    public List<Double> averageOfLexels2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Double> res = new ArrayList<>();

        int count = 0;
        int sum = 0;

        queue.offer(root);
        while (! queue.isEmpty()) {

            count = queue.size();
            sum = 0;

            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.poll();
                sum += temp.val;

                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }

            Double result = (double)sum / count;

            res.add(result);
        }

        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> sum = new ArrayList<>();
        List<Double> res = new ArrayList<>();

        // 深度优先
        dfs(0, root, count, sum);

        for (int i = 0; i < count.size(); i++) {
            res.add(sum.get(i) / count.get(i));
        }

        return res;
    }

    // 深度优先
    private void dfs(int level, TreeNode treeNode, List<Integer> count, List<Double> sum) {

        if (treeNode == null) return;

        if (level < count.size()) {
            count.set(level, count.get(level) + 1);
            sum.set(level, sum.get(level) + treeNode.val);
        } else {
            count.add(1);
            sum.add(treeNode.val * 1.0);
        }

        dfs(level + 1, treeNode.left, count, sum);
        dfs(level + 1, treeNode.right, count, sum);

    }


}
