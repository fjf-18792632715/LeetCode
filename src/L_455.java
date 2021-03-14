import java.util.Arrays;

public class L_455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int sIndex = 0;
        for (int i = 0; i < g.length; i++) {
            int temp = g[i];
            while (sIndex < s.length && s[sIndex] < temp) sIndex++;
            if (sIndex == s.length) {
                return count;
            }
            count++;
            sIndex++;
        }

        return count;
    }

}
