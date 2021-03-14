
import java.util.*;

public class L_692 {

    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }

            NumberAndCount[] res = new NumberAndCount[map.size()];
            int index = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String word = entry.getKey();
                int count = entry.getValue();
                NumberAndCount nac = new NumberAndCount(count, word);
                res[index++] = nac;
            }

            Arrays.sort(res);

            List<String> array = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                array.add(res[i].word);
            }

            return array;
        }
    }

    class NumberAndCount implements Comparable<NumberAndCount> {
        int count;
        String word;

        public NumberAndCount(int count, String word) {
            this.count = count;
            this.word = word;
        }

        @Override
        public int compareTo(NumberAndCount o) {
            if (this.count == o.count) {
                return this.word.compareTo(o.word);
            } else {
                return o.count - this.count;
            }
        }
    }

}
