import org.omg.CORBA.INTERNAL;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_47 {
    public static void main(String[] args) {

        L_47 demo = new L_47();
        System.out.println(demo.permuteUnique(new int[]{1, 1, 2}));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];

        Method(nums, 0, res, list, flag);

        return res;
    }

    public void Method(int[] array, int start, List<List<Integer>> res, List<Integer> list, boolean[] flag) {
        if (list.size() == array.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < array.length; i++) {
            if (flag[i]) continue;
//            if (i > start && array[i] == array[i - 1] && !flag[i - 1]) continue;
            list.add(array[i]);
            flag[i] = true;
            Method(array, 0, res, list, flag);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }

//    public boolean contain(String str1, String str2) {
//        for (int i = 0; i < str1.length(); i++) {
//            char temp = str1.charAt(i);
//            if (!str2.contains(new StringBuilder(temp).toString())) {
//                return false;
//            }
//        }
//        return true;
//    }
}
