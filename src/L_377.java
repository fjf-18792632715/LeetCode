import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 377.组合总和Ⅳ
 */

public class L_377 {

    public static void main(String[] args) {

        Date time = new Date();

        long time1 = time.getTime();

        L_377 demo = new L_377();
        System.out.println(demo.combinationSum4(new int[]{4, 2, 1}, 32));

        long time2 = time.getTime();
        System.out.println(time2 - time1);
    }

    int count = 0;

    public int combinationSum4(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        Method(0, list, nums, target);

        return count;
    }

    private void Method(int start, List<Integer> list, int[] nums, int target) {

        if (sum(list) == target) {
            count++;
            return;
        } else if (sum(list) > target) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            Method(i, list, nums, target);
            list.remove(list.size() - 1);
        }

    }

    public int sum(List<Integer> list) {
        int temp = 0;
        for (Integer integer : list) {
            temp += integer;
        }

        return temp;
    }

}
