import java.util.*;

public class L_52 {
    // 记录总数
    int count = 0;
    public int totalNQueens(int n) {
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

        dfs(array, row, n, list1, list2, list3);

        return count;
    }

    public void dfs(int[] array, int row, int n, Set<Integer> list1, Set<Integer> list2, Set<Integer> list3) {
        // row == n 说明已经解决一种方案，直接转化为集合输入结果集合。
        if (row == n) {
            count++;
        } else {
            // 说明方案数组还没有完成，需要继续递归构造
            for (int i = 0; i < array.length; i++) {
                if (!list1.contains(i) && !list2.contains(i - row) && !list3.contains(i + row)) {
                    array[row] = i;
                    list1.add(i);
                    list2.add(i - row);
                    list3.add(i + row);
                    dfs(array, row + 1, n, list1, list2, list3);
                    array[row] = -1;
                    list1.remove(i);
                    list2.remove(i - row);
                    list3.remove(i + row);
                }
            }
        }
    }
}
