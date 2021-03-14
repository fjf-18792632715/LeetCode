
import java.util.*;

public class L_51 {

    /**
     *    N 皇后问题。
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // 记录每一行的皇后位置
        int[] array = new int[n];
        Arrays.fill(array, -1);
        // 记录该位置是否是已有皇后的列
        Set<Integer> list1 = new HashSet<>();
        // 记录该位置是否是已有皇后的正对角线
        Set<Integer> list2 = new HashSet<>();
        // 记录该位置是否是已有皇后的负对角线
        Set<Integer> list3 = new HashSet<>();
        // 记录行数
        int row = 0;

        dfs(res, array, row, n, list1, list2, list3);

        return res;

    }

    // 进行深度优先搜索，核心代码
    public void dfs(List<List<String>> res, int[] array, int row, int n, Set<Integer> list1, Set<Integer> list2, Set<Integer> list3) {
        // row == n 说明已经解决一种方案，直接转化为集合输入结果集合。
        if (row == n) {
            res.add(buildSolve(array, n));
        } else {
            // 说明方案数组还没有完成，需要继续递归构造
            for (int i = 0; i < array.length; i++) {
               /* if (list1.contains(i)) {
                    continue;
                }
                if (list2.contains(i - row)) {
                    continue;
                }
                if (list3.contains(i + row)) {
                    continue;
                }*/

               if (!list1.contains(i) && !list2.contains(i - row) && !list3.contains(i + row)) {
                   // 找到空位，将该层的皇后位置摆放
                   array[row] = i;
                   // 设置该列后面不可用
                   list1.add(i);
                   // 设置正对角线
                   list2.add(i - row);
                   // 设置负对角线
                   list3.add(i + row);
                   // 进入下一层递归
                   dfs(res, array, row + 1, n, list1, list2, list3);
                   // 完成上一步递归后参数复原
                   array[row] = -1;
                   list1.remove(i);
                   list2.remove(i - row);
                   list3.remove(i + row);
               }
            }
        }
    }

    // 使用已经确定可以成功的方案数组，构造结果集合
    public List<String> buildSolve(int[] array, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == array[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }

        return list;
    }

    public static void main(String[] args) {
        L_51 demo = new L_51();
        List<List<String>> list = demo.solveNQueens(4);
        for (List<String> subList : list) {
            System.out.println(subList);
        }
    }
}
