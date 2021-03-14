import java.util.HashMap;
import java.util.Map;

public class L_997 {
    public static void main(String[] args) {

    }

    // 用数组标记
    public int findJudge(int N, int[][] trust) {

        if (trust.length == 0) {
            if (N == 1) return 1;
            return -1;
        }

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = 0;
        }

        for (int i = 0; i < trust.length; i++) {
            array[trust[i][1] - 1]++;
        }

        int max = 0;
        int maxId = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                maxId = i + 1;
            }
        }

        if (max != N - 1) return -1;
        for (int i = 0; i < trust.length; i++) {
            if (trust[i][0] == maxId) return -1;
        }

        return maxId;


    }


    // 用hashmap做
    public int findJudge1(int N, int[][] trust) {

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int maxId = 0;

        for (int i = 0; i < trust.length; i++) {
            int[] temp = trust[i];
            if (map.containsKey(temp[1])) {
                map.put(temp[1], map.get(temp[1]) + 1);
            } else {
                map.put(temp[1], 1);
            }

            for (Integer key : map.keySet()) {
                int val = map.get(key);
                if (val > max) {
                    max = val;
                    maxId = key;
                }
            }

        }

        if (max != N) return -1;
        for (int i = 0; i < trust.length; i++) {
            if (maxId == trust[i][0]) return -1;
        }

        return maxId;
    }
}
