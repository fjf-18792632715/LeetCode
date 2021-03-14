import java.util.*;

/**
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */

public class L_347_V2 {
    public static void main(String[] args) {
        L_347_V2 demo = new L_347_V2();
        int[] array = demo.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        System.out.println(Arrays.toString(array));


    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int[] array = new int[k];
        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);  // getOrderDefault：如果存在这个key键值对，就返回num，不存在就返回后面设定的num
        }

        System.out.println(map);

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                }
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

//            if (queue.size() == k) break;

            queue.offer(entry);
        }

        System.out.println(queue);

        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll().getKey();
        }
        return ret;
    }
}
