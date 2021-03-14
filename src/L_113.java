import java.util.ArrayList;
import java.util.List;

public class L_113 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;

        list.add(root.val);

        if (sumList(list) > sum) return res;

        if (root.left != null) {
            pathSum(root.left, sum);
        }

        if (root.right != null) {
            pathSum(root.right, sum);
        }

        if (root.left == null && root.right == null) {
            if (sumList(list) == sum) {
                res.add(new ArrayList<>(list));
            }
        }

        list.remove(list.size() - 1);

        return res;
    }

    public int sumList(List<Integer> list) {
        int temp = 0;
        for (Integer integer : list) {
            temp += integer;
        }

        return temp;
    }
}
