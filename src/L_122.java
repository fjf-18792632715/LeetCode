public class L_122 {

    public static void main(String[] args) {
        L_122 demo = new L_122();
        System.out.println(demo.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = 1;
        int count = 0;

        while (leftIndex < prices.length && rightIndex < prices.length) {
            if (prices[leftIndex] < prices[rightIndex]) {
                while (rightIndex < prices.length && prices[rightIndex] > prices[rightIndex - 1]) {
                    rightIndex++;
                }

                int temp = (prices[rightIndex - 1] - prices[leftIndex]);

                count += temp;
                leftIndex = rightIndex - 1;
            } else {
                leftIndex++;
                rightIndex++;
            }
        }

        return count;
    }
}
