import java.util.Arrays;

public class L_300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        // 一定要全部初始化为1，要不然如果遇见递减序列dp[i]=0
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

}
