
import java.util.*;

public class L_56 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) return new int[0][2];

            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < intervals.length; i++) {
                if (list.size() == 0 || intervals[i][0] > list.get(list.size() - 1)[1]) {
                    list.add(intervals[i]);
                } else {
                    list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
                }
            }

            return list.toArray(new int[list.size()][]);
        }
    }


    // 行不通
/*    class Solution {
        public int[][] merge(int[][] intervals) {
            List<List<Integer>> list = new ArrayList<>();
            int maxNumber = 0;
            List<Integer> tempList = new ArrayList<>();
            for (int i =  0; i < intervals.length; i++) {
                maxNumber = maxNumber > intervals[i][1] ? maxNumber : intervals[i][1];
            }

            boolean[] array = new boolean[maxNumber + 1];
            Arrays.fill(array, false);

            for (int i = 0; i < intervals.length; i++) {
                // 处理相等问题
                if (intervals[i][0] == intervals[i][1]) {
                    tempList.add(intervals[i][0]);
                }
                for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                    array[j] = true;
                }
            }

            tempList.sort(Comparator.comparingInt(o -> o));

            int left;
            int right;
            int index = 0;
            while (index < array.length) {
                if (array[index]) {
                    left = index;
                    while (array[index]) index++;
                    right = index;

                    if (!tempList.isEmpty()) {
                        while (!tempList.isEmpty() && tempList.get(0) >= left && tempList.get(0) <= right) {
                            tempList.remove(0);
                        }
                    }

                    List<Integer> temp = new ArrayList<>();
                    temp.add(left);
                    temp.add(right);
                    list.add(temp);
                } else {
                    index++;
                }
            }

            if (!tempList.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (tempList.isEmpty()) break;
                    if (tempList.get(0) < list.get(i).get(0)) {
                        List<Integer> t = new ArrayList<>();
                        t.add(tempList.get(0));
                        t.add(tempList.get(0));
                        tempList.remove(0);
                        list.add(i, t);
                    }
                }
            }

            while (!tempList.isEmpty()) {
                List<Integer> t = new ArrayList<>();
                t.add(tempList.get(0));
                t.add(tempList.get(0));
                tempList.remove(0);
                list.add(t);
            }

            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i][0] = list.get(i).get(0);
                res[i][1] = list.get(i).get(1);
            }

            return res;

        }
    }*/

}
