public class L_771 {

    class Solution {
        public int numJewelsInStones(String J, String S) {
            int[] res = new int[58];
            int count = 0;
            for (int i = 0; i < S.length(); i++) {
                res[S.charAt(i) - 'A']++;
            }

            for (int i = 0; i < J.length(); i++) {
                count += res[J.charAt(i - 'A')];
            }

            return count;
        }
    }

}
