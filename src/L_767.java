import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L_767 {

    public static void main(String[] args) {
        L_767 demo = new L_767();
        System.out.println(demo.reorganizeString("aab"));
    }

    public String reorganizeString(String S) {
        int[] hash = new int[26];
        int strLength = S.length();
        int max = 0;
        char[] res = new char[strLength];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
            max = Math.max(max, hash[S.charAt(i) - 'a']);
//            max = max > hash[S.charAt(i) - 'a'] ? max : hash[S.charAt(i) - 'a'];
        }
        if (max > (strLength + 1) / 2) return "";

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return hash[o2 - 'a'] - hash[o1 - 'a'];
            }
        });

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                queue.offer((char) (i + 'a'));
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            Character temp = queue.poll();
            for (int i = 0; i < hash[temp - 'a']; i++) {
                if (index <= res.length - 1) {
                    res[index] = temp;
                    index += 2;
                } else {
                    index = 1;
                    res[index] = temp;
                    index += 2;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }

        return sb.toString();
    }
}
