import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.Map;

public class L_659 {

    public boolean isPossible(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (i < nums.length - 2) {
                if (map.containsKey(temp) && map.get(temp) > 0) {
                    if (tail.containsKey(temp - 1) && tail.get(temp - 1) != 0) {
                        tail.put(temp - 1, tail.get(temp - 1) - 1);
                        tail.put(temp, tail.get(temp) + 1);
                        map.put(temp, map.get(temp) - 1);
                    } else {
                        if (map.containsKey(temp + 1) && map.containsKey(temp + 2) && map.get(temp + 1) > 0 && map.get(temp + 2) > 0) {
//                            tail[temp + 2]++;
                            tail.put(temp + 2, tail.get(temp + 2) + 1);
//                            map[temp]--;
                            map.put(temp, map.get(temp) - 1);
//                            map[temp + 1]--;
                            map.put(temp + 1, map.get(temp + 1) - 1);
//                            map[temp + 2]--;
                            map.put(temp + 2, map.get(temp + 2) - 1);
                        } else {
                            return false;
                        }
                    }
                }
            } else {
                if (map.containsKey(temp) && map.get(temp) > 0) {
                    if (tail.containsKey(temp - 1) && tail.get(temp - 1) != 0) {
                        tail.put(temp - 1, tail.get(temp - 1) - 1);
                        tail.put(temp, tail.get(temp) + 1);
                        map.put(temp, map.get(temp) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
