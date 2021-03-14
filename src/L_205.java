import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L_205 {

    public static void main(String[] args) {
        L_205 demo = new L_205();
        System.out.println(demo.isIsomorphic("ab", "aa"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (set.contains(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }

        return true;
    }

}
