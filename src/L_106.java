import java.util.HashMap;
import java.util.Map;

public class L_106 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            this.map.put(i, inorder[i]);
        }

        return null;
    }

    public void method(int start, int end, int[] inorder, int[] postorder, int index) {

    }
}
