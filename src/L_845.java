import java.sql.PreparedStatement;
import java.sql.SQLRecoverableException;

public class L_845 {

    public static void main(String[] args) {
        L_845 demo = new L_845();
        System.out.println(demo.longestMountain(new int[]{2, 2, 2, 2, 2, 2}));
    }

    // 动态规划
    public int longestMountain(int[] array) {
        if (array.length < 3) return 0;
        int start = 0;
        int peak = -1;
        int maxPeak = 0;

        for (int i = 1; i < array.length; i++) {
            // 没山峰
            if (start > peak) {
                if (array[i] > array[i - 1]) {
                    peak = i;
                } else {
                    start = i;
                }
            } else {
                // 有山峰
                if (array[i] == array[i - 1]) {
                    start = i;
                } else if (array[i] > array[i - 1]) {
                    if (array[i - 1] > array[i - 2]) {
                        peak = i;
                    } else {
                        start = i - 1;
                        peak = i;
                    }
                } else {
                    int length = i - start + 1;
                    maxPeak = maxPeak > length ? maxPeak : length;
                }
            }
        }
        return maxPeak;
    }
}
