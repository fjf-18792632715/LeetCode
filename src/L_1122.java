import sun.reflect.generics.tree.Tree;

import java.util.*;

public class L_1122 {

    public static void main(String[] args) {
        L_1122 demo = new L_1122();
        int[] ints = demo.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        System.out.println(Arrays.toString(ints));
    }

    // 方法二：使用ArrayList和HashMap
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : arr2) {
            map.put(i, 0);
        }

        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                list.add(i);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int index = 0;
        int size = 0;
        for (int i : arr2) {
            size = map.get(i);
            for (int j = 0; j < size; j++) {
                arr1[index++] = i;
            }
            map.remove(i);
        }

        while (!list.isEmpty()) {
            arr1[index++] = list.remove(list.size() - 1);
        }

        return arr1;
    }


    // 方法一：使用HashMap和TreeMap进行添加在排序（超过30%）
   public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int index = 0;
        for (int i : arr2) {
            int size = map.get(i);
            for (int j = 0; j < size; j++) {
                arr1[index++] = i;
            }
            map.remove(i);
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(map);

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int size = entry.getValue();
            for (int i = 0; i < size; i++) {
                arr1[index++] = entry.getKey();
            }
        }

        return arr1;
    }

}
