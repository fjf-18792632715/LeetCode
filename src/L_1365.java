import javax.swing.text.StyleContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class L_1365 {

    public static void main(String[] args) {
        L_1365 demo = new L_1365();
        int[] array = demo.smallerNumbersThanCurrent1(new int[]{8, 1, 2, 2, 3});
        System.out.println(Arrays.toString(array));
    }

    // 暴力解法
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] array = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[j] < temp) array[i]++;
            }
        }
        return array;
    }


    // 快速排序
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] array;
        array = Arrays.copyOf(nums, nums.length);
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            exchange(array, i, 0);
            res[i] = searchIndex(array);
            array = Arrays.copyOf(nums, nums.length);
        }

        return res;
    }

    public int searchIndex(int[] array) {
        if (array.length == 1) return 0;
        int left = 0;
        int right = array.length - 1;
        int num = array[0];
        while (left < right) {
            while (left < right && array[left] < num) left++;
            while (left < right && array[right] >= num) right--;

            exchange(array, left, right);
        }

        while (left > 0 && array[left] == array[left - 1]) left--;

        return left;

    }

    public void exchange(int[] array, int left, int right) {
        if (left == right) return;
        array[left] ^= array[right];
        array[right] ^= array[left];
        array[left] ^= array[right];
    }
}
