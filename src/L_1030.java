import java.util.*;

public class L_1030 {

    public static void main(String[] args) {
        L_1030 demo = new L_1030();
        int[][] ints = demo.allCellsDistOrder(1, 2, 0, 0);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int temp = method(r0, c0, i, j);
                if (map.containsKey(temp)) {
                    map.get(temp).add(new int[]{i, j});
                } else {
                    List<int[]> t = new ArrayList<>();
                    t.add(new int[]{i, j});
                    map.put(temp, t);
                }
            }
        }

        int index = 0;
        int[][] res = new int[R * C][2];
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            for (int[] temp : entry.getValue()) {
                res[index][0] = temp[0];
                res[index][1] = temp[1];
                index++;
            }
        }

        return res;
    }

    public int method(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}
