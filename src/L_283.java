import java.util.Arrays;

public class L_283 {

    public static void main(String[] args) {
        L_283 demo = new L_283();
        int[] array = new int[]{0};
        demo.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }


    // 牛逼
    public void moveZeroes(int[] nums) {
        int p0 = 0;
        int p1 = p0;
        while (p0 < nums.length) {
            while (p0 < nums.length && nums[p0] == 0) p0++;
            if (p0 < nums.length) {
                nums[p1++] = nums[p0++];
            }
        }
        for (;p1 < nums.length; p1++) {
            nums[p1] = 0;
        }
    }



    // 辣鸡
    public void moveZeroes1(int[] nums) {
        int p0 = nums.length - 1;
        int p1 = p0;

        while (p0 >= 0 && p1 >= 0) {
            while (p1 >= 0 && nums[p1] == 0) p1--;
            while (p0 >= 0 && (nums[p0] != 0 || p0 >= p1)) p0--;

            if (p0 >= 0) change(nums, p0, p1);
        }
    }

    public void change(int[] array, int p0, int p1) {
        if (p1 - 1 == p0) {
            reverse(array, p0, p1);
        } else {
            reverse(array, p0 + 1, p1);
            reverse(array, p0, p1);
        }
    }

    public void reverse(int[] array, int start, int end) {
        while (start < end) {
            array[start] ^= array[end];
            array[end] ^= array[start];
            array[start] ^= array[end];
            start++;
            end--;
        }
    }

}
