import java.util.*;
import java.util.stream.Stream;

public class L_349 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12345);
        list.add(45);
        list.add(8);
        Stream<Integer> stream = list.stream();
        // 把list集合转化为一个基本类型的数组返回
        int[] array = stream.mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(array));
    }


    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                if (!set.contains(nums1[i])) {
                    set.add(nums1[i]);
                }
            }

            for (int i = 0; i < nums2.length; i++) {
                if (set.contains(nums2[i])) {
                    list.add(nums2[i]);
                    set.remove(nums2[i]);
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.remove(0);
            }
            return res;
        }
    }

}
