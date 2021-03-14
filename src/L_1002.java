import java.util.ArrayList;
import java.util.List;

public class L_1002 {

    public static void main(String[] args) {
    }

    public List<String> commonChars(String[] A) {
        int[] array = new int[26];
        int[] temp = new int[26];
        for (int i = 0; i < array.length; i++) {
            array[i] = 100;
            temp[i] = 0;
        }

        for (int i = 0; i < A.length; i++) {
            String str = A[i];
            for (int j = 0; j < str.length(); j++) {
                temp[str.charAt(j) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                array[j] = Math.min(array[j], temp[j]);
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int count = array[i];
            char ch = (char) (i + 'a');

            for (int j = 0; j < count; j++) {
                res.add(String.valueOf(ch));
            }
        }

        return res;
    }
}
