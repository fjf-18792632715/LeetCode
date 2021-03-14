import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;
import java.util.Comparator;

public class L_1024 {


    // 贪心算法YES YES YES!!!
    public int videoStitching2(int[][] clips, int T) {
        int[] array = new  int[T];
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] >= T) continue;
            array[clips[i][0]] = Math.max(array[clips[i][0]], clips[i][1]);
        }

        int res = 0;
        int last = 0;
        int pre;

        for (int i = 0; i < T; i++) {
            last = Math.max(last, array[i]);
            pre = last;
            if (last == i) return -1;
            res++;
            for (; i < pre; i++) {
                last = Math.max(last, array[i]);
            }
        }

        return res;

    }

    // 动态规划方法YES！
    public int videoStitching1(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, clips.length + 1);
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }

        return dp[T] == clips.length + 1 ? -1 : dp[T];
    }


    // 可以通过 但是超时，最好用动态规划
    public int videoStitching(int[][] clips, int T) {
        this.count = 0;
        this.array = new int[T];
        this.minCount = clips.length;

        dfs(0 , clips);

        if (f) {
            return minCount;
        } else {
            return -1;
        }
    }

    private boolean f = false;
    int count;
    int[] array;
    private int minCount;
    public void dfs(int start, int[][] clips) {
        if (count > minCount) return;

        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                flag = false;
            }
        }
        if (flag) {
            this.f = true;
            minCount = count;
            return;
        }

        for (int i = start; i < clips.length; i ++) {
            addArray(array, clips[i]);
            count++;
            dfs(i + 1, clips);
            delArray(array, clips[i]);
            count--;
        }
    }

    public void addArray(int[] array, int[] add) {
        int rightIndex = add[1] > array.length ? array.length : add[1];
        for (int i = add[0]; i < rightIndex; i++) {
            array[i]++;
        }
    }

    public void delArray(int[] array, int[] del) {
        int rightIndex = del[1] > array.length ? array.length : del[1];
        for (int i = del[0]; i < rightIndex; i++) {
            array[i]--;
        }
    }
}
