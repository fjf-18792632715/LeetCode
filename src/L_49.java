import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_49 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (3 + 'a'));
        System.out.println(sb.toString());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        char[] hash = new char[26];

        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                hash[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] > 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(hash[i]);
                    hash[i] = 0;
                }
            }

            String string = sb.toString();
            if (map.containsKey(string)) {
                map.get(string).add(str);
            } else {
                List<String> list = new ArrayList<>();
                res.add(list);
                list.add(str);
                map.put(string, list);
            }
        }

        return res;
    }
}
