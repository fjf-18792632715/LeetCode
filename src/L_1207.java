import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *          map.value() : 功能是返回所有value组成的集合
 *          map.keySet() : 返回的是key组成的集合
 */

public class L_1207 {

    public static void main(String[] args) {
        String string = "hello";
        Map<Integer, String> map = new HashMap<>();
        map.put(1, string);
        map.put(2, string);
        map.put(3, string);

        string = "world";
        System.out.println(map.values());
        System.out.println(map.keySet());
    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Set<Integer> set = new HashSet<>(map.values());

        return set.size() == map.size();
    }
}
