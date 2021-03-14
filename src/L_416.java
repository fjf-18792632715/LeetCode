import java.util.Arrays;

public class L_416 {

    /**
     *  分割等和子集：
     *      1. 首先使用深度优先遍历，即dfs，超时
     *      2. 尝试使用动态规划二维 dp 数组来做，但是不会，需要看答案
     */

    // 二维 dp 数组
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (max < nums[i]) max = nums[i];
        }
        if (sum % 2 == 1) return false;
        int mid = sum / 2;
        if (max > mid) return false;

        boolean[][] dp = new boolean[nums.length][mid + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;

        for (int i = 1; i < dp.length; i++) {
            int temp = nums[i];
            for (int j = 1; j < dp[0].length; j++) {
                if (j < temp) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - temp] || dp[i -1][j];
                }
            }
        }

        return dp[nums.length - 1][mid];

    }

    // 一维 dp 数组(两个)
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (max < nums[i]) max = nums[i];
        }
        if (sum % 2 == 1) return false;
        int mid = sum / 2;
        if (max > mid) return false;

        boolean[] dp = new boolean[mid + 1];
        boolean[] preDp = new boolean[mid + 1];

        preDp[0] = true;
        preDp[nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j < nums[i]) {
                    dp[j] = preDp[j];
                } else {
                    dp[j] = preDp[j - nums[i]] || preDp[j];
                }
            }

            preDp = dp.clone();
        }



        return dp[mid];

    }

    // 一维 dp 数组（一个数组）
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (max < nums[i]) max = nums[i];
        }
        if (sum % 2 == 1) return false;
        int mid = sum / 2;
        if (max > mid) return false;

        boolean[] dp = new boolean[mid + 1];

        dp[0] = true;
        dp[nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; --j) {
                dp[j] = dp[j - nums[i]] || dp[j];
            }
        }

        return dp[mid];

    }

}
