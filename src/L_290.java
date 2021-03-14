import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， 
 * pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 */

public class L_290 {
    public static void main(String[] args) {
        L_290 demo = new L_290();

        System.out.println(demo.wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");

        if (chars.length != strings.length) return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(chars[i])) {
                if (!map.get(chars[i]).equals(strings[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strings[i])) return false;
                map.put(chars[i], strings[i]);
            }
        }

        return true;
    }
}
