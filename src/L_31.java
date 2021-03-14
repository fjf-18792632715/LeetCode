import java.util.Arrays;

public class L_31 {

    public static void main(String[] args) {
        L_31 demo = new L_31();
        int[] array = new int[]{6,1,5,4,3,2};
        demo.nextPermutation(array);
        System.out.println(Arrays.toString(array));

    }

    /**
     *  思路：
     *      1. 首先从最后一位开始遍历，找到前一位比后一位小的情况，如果没找到说明这个组合是最大的，直接反转然后返回
     *      2. 找到 array[index + 1] > array[index]，的index
     *      3. 再从index + 1 开始向后寻找，找到最小的一个比array[index]大的数（后面的数字必定是单调递减的）
     *      4. 将找到的数字和index位置上的数字交换
     *      5. 再将从 index + 1 位置开始到最后一位的所有数字反转即可
     *
     */

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;

        int index = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i -1]) {
                index = i - 1;
                break;
            }
            if (i == 1) {
                reverse(nums, 0, nums.length - 1);
                return;
            }
        }

        int temp = index + 1;
        while (temp < nums.length && nums[temp] > nums[index]) temp++;
        temp--;

        nums[temp] ^= nums[index];
        nums[index] ^= nums[temp];
        nums[temp] ^= nums[index];

        reverse(nums, index + 1, nums.length - 1);

    }

    public void reverse(int[] array, int i, int j) {
        if (i == j) return;
        for (; i < j; i++, j--) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
        }
    }
}
