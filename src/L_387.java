import java.util.Arrays;

public class L_387 {

    public static void main(String[] args) {
        L_387 demo = new L_387();
        System.out.println(demo.firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        int[] hash = new int[26];
        Arrays.fill(hash, 0);

        for (int i = 0; i < s.length(); i++) {
            hash[array[i] - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash[array[i] - 'a'] == 1) return i;
        }
        return -1;
    }

}
