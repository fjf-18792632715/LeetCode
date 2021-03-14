
import java.util.*;

public class L_127_图的DFS {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            Set<String> wordSet = new HashSet<>(wordList);
            wordSet.remove(beginWord);
            Set<String> visited = new HashSet<>();
            if (!wordSet.contains(endWord)) return 0;
            visited.add(beginWord);
            int step = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String temp = queue.poll();
                    char[] charArray = temp.toCharArray();

                    for (int j = 0; j < temp.length(); j++) {
                        char wordTemp = charArray[j];

                        for (char k = 'a'; k <= 'z'; k++) {
                            if (k == wordTemp) continue;
                            charArray[j] = k;

                            String str = String.valueOf(charArray);
                            if (str.equals(endWord)) return step + 1;
                            if (wordSet.contains(str) && !visited.contains(str)) {
                                queue.add(str);
                                visited.add(str);
                            }
                        }

                        charArray[j] = wordTemp;
                    }
                }
                step++;
            }

            return 0;
        }
    }

}
