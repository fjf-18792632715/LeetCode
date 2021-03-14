import sun.reflect.generics.tree.Tree;

public class L_701 {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        TreeNode cur = root;
        TreeNode pre = cur;
        while (cur != null) {
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        TreeNode node = new TreeNode(val);

        if (pre.val > val) {
            pre.left = node;
        } else {
            pre.right = node;
        }

        return root;

    }



}
