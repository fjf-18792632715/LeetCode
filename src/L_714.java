public class L_714 {

    public static void main(String[] args) {
        L_714 demo = new L_714();
        System.out.println(demo.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    // 贪心
    public int maxProfit(int[] prices, int fee) {
        int sum = 0;
        int start = 0;
        int end = start + 1;
        int temp = start;

        while (end < prices.length) {

            if (temp == start) {
                if (prices[end] - prices[start] - fee > 0) {
                    sum += prices[end] - prices[start] - fee;
                    System.out.println(sum);
                    temp = end;
                } else if (prices[end] < prices[start]) {
                    start = end;
                    temp = start;
                }
            }else {
                if (prices[end] > prices[temp]) {
                    sum += prices[end] - prices[temp];
                    temp = end;
                } else if (prices[end] + fee < prices[temp]) {
                    start = end;
                    temp = start;
                }
            }

            end++;
        }

        return sum;
    }


    // 牛逼dp
    public int maxProfit2(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2]; // 0没有股票，1持有股票
        dp[0][0] = 0;
        dp[0][1] = 0 - prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] - prices[i]);
        }

        return dp[dp.length - 1][0];
    }


    // 辣鸡dp，超时
    public int maxProfit1(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        dp[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] <= prices[j]) {
                    dp[i] = dp[i - 1];
                    continue;
                }
                max = Math.max(max, dp[j] + prices[i] - prices[j] - fee);
            }
            dp[i] = Math.max(max, dp[i - 1]);
        }

        return dp[dp.length - 1];
    }

}
