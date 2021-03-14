import java.util.*;

public class L_819 {

    public static void main(String[] args) {

    }

    class Solution {
        // 逐字符读取
        public String mostCommonWord(String paragraph, String[] banned) {
            String s = paragraph.toLowerCase();
            Map<String, Integer> map = new HashMap<>();
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                char temp = array[i];
                if (temp < 'a' || temp > 'z') continue;
                StringBuilder sb = new StringBuilder();
                while (i < array.length && array[i] >= 'a' && array[i] <= 'z') {
                    sb.append(array[i]);
                    i++;
                }

                if (map.containsKey(sb.toString())) {
                    map.put(sb.toString(), map.get(sb.toString()) + 1);
                } else {
                    map.put(sb.toString(), 1);
                }
            }

            for (String s1 : banned) {
                if (map.containsKey(s1)) {
                    map.remove(s1);
                }
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            return list.remove(0).getKey();
        }


        // 分割：麻烦
        /*public String mostCommonWord(String paragraph, String[] banned) {
            String s1 = paragraph.toLowerCase();

            String[] string = s1.trim().split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (String s : string) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char temp = s.charAt(i);
                    if (temp >= 'a' && temp <= 'z') {
                        sb.append(temp);
                    }
                }
                s = sb.toString();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }

            for (String s : banned) {
                if (map.containsKey(s)) {
                    map.remove(s);
                }
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((o1, o2) -> o2.getValue() - o1.getValue());

            return list.get(0).getKey();
        }*/
    }

}
