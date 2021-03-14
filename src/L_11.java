public class L_11 {
    public static void main(String[] args) {
        L_11 demo = new L_11();
        System.out.println(demo.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxV = 0;

        while (left < right) {
            int V = Math.min(height[left], height[right]) * (right - left);
            maxV = Math.max(maxV, V);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxV;
    }
}
