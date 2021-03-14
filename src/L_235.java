import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class L_235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        map.put(root, null);
        int max = p.val > q.val ? p.val : q.val;
        TreeNode preIndex = null;

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();

            if (temp.right != null) {
                map.put(temp.right, temp);
                stack.push(temp.right);
            }

            if (temp.left != null) {
                map.put(temp.left, temp);
                stack.push(temp.left);
            }
        }

        for (TreeNode treeNode : map.keySet()) {
            if (map.get(treeNode) != null) {
                System.out.println("key: " + treeNode.val + "  value: " + map.get(treeNode).val);
            } else {
                System.out.println("key: " + treeNode.val + "  value: null");
            }
        }

        TreeNode res = p;

        while (res != null) {
            TreeNode temp = q;
            while (temp != null) {
                if (temp == res) {
                    return res;
                } else {
                    temp = map.get(temp);
                }
            }
            res = map.get(res);
        }

        return null;
    }

}
