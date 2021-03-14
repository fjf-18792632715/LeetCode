import java.util.ArrayList;
import java.util.List;

public class L_57 {

    public static void main(String[] args) {
        L_57 demo = new L_57();

    }

    class Solution {
        public int[][] insert(int[][] intervals, int[] newrval) {
            if (intervals.length == 0) {
                int[][] res = new int[1][2];
                res[0][0] = newrval[0];
                res[0][1] = newrval[1];
                return res;
            }
            List<int[]> list = new ArrayList<>();
            int left = newrval[0];
            int right = newrval[1];
            boolean flag = true;

            for (int i = 0; i < intervals.length; i++) {
                if (flag && left <= intervals[i][1]) {
                    // 左边界在该区域的左边或者中间
                    left = Math.min(left, intervals[i][0]);
                    while (i < intervals.length && right >= intervals[i][0]) {
                        right = Math.max(right, intervals[i][1]);
                        i++;
                    }
                    int[] temp = new int[2];
                    temp[0] = left;
                    temp[1] = right;
                    list.add(temp);
                    i--;
                    flag = false;
                } else {
                    list.add(intervals[i]);
                }
            }
            if (flag) {
                list.add(newrval);
            }

            return list.toArray(new int[list.size()][]);
        }
    }

}
