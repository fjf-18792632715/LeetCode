import java.util.*;
import java.util.function.BiConsumer;

/**
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */

public class L_347 {
    public static void main(String[] args) {
        L_347 demo = new L_347();
        int[] array = demo.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(array));

        /*TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 111);
        map.put(2, 222);
        map.put(3, 33);
        map.put(4, 444);
        map.put(5, 555);

        System.out.println(map);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.println(list);*/

    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int[] array = new int[k];
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {  // 如果存在key映射
                map.replace(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // 排序
        if (!map.isEmpty()){
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());  // 将map转化为set形式再存储至list中
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            //System.out.println(list);

            int count = 0;
            for (Map.Entry<Integer, Integer> entry : list) {
                if (count == k) break;
                array[count] = entry.getKey();
                count++;
            }
        }

        return array;
    }


}
