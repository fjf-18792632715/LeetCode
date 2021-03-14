import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;
import java.util.List;

public class L_129 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        dfs(root, sb);

        System.out.println(res);

        for (Integer integer : res) {
            sum += integer;
        }

        return sum;

    }

    List<Integer> res = new ArrayList<>();

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                res.add(Integer.parseInt(sb.toString()));
            }

            if (root.left != null) {
                dfs(root.left, sb);
            }

            if (root.right != null) {
                dfs(root.right, sb);
            }

            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
