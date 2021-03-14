public class L_327_归并计数 {

    public static void main(String[] args) {
        L_327_归并计数 demo = new L_327_归并计数();
        System.out.println(demo.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647}, -564, 3864));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] temp = new long[nums.length + 1];
        long[] preSumArray = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSumArray[i] = preSumArray[i - 1] + nums[i - 1];
        }

//        System.out.println(Arrays.toString(preSumArray));

        int count = merge(preSumArray, temp, 0, preSumArray.length - 1, lower, upper);

//        System.out.println(Arrays.toString(preSumArray));
        return count;
    }

    public int merge(long[] preSunArray, long[] temp, int L, int R, int low, int up) {

        if (L >= R) return 0;
        int mid = (L + R) / 2;
        int count1 = merge(preSunArray, temp, L, mid, low, up);
        int count2 = merge(preSunArray, temp, mid + 1, R, low, up);

        // 计数
        int count = count1 + count2;
        int leftIndex = L;
        int lowIndex = mid + 1;
        int upIndex = lowIndex;

//        System.out.println("-------------------------------");
        while (leftIndex < mid + 1 && lowIndex <= R) {
            long num = preSunArray[leftIndex];
            while (lowIndex <= R && preSunArray[lowIndex] - num < low) {
                lowIndex++;
//                upIndex++;
            }

            while (upIndex <= R && preSunArray[upIndex] - num <= up) {
                upIndex++;
            }
            count += upIndex - lowIndex;
//            System.out.println("leftIndex = " + leftIndex);
//            System.out.println("upIndex = " + upIndex + "    " + "lowIndex = " + lowIndex);
//            System.out.println(count);
            leftIndex++;
        }

        // 归并排序
        leftIndex = L;
        int rightIndex = mid + 1;
        int index = L;
        while (leftIndex <= mid || rightIndex <= R) {
            if (leftIndex > mid) {
                temp[index++] = preSunArray[rightIndex++];
            } else if (rightIndex > R) {
                temp[index++] = preSunArray[leftIndex++];
            } else {
                if (preSunArray[leftIndex] <= preSunArray[rightIndex]) {
                    temp[index++] = preSunArray[leftIndex++];
                } else {
                    temp[index++] = preSunArray[rightIndex++];
                }
            }
        }
        for (int i = L; i <= R; i++) preSunArray[i] = temp[i];

        return count;
    }
}