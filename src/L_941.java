public class L_941 {

    public static void main(String[] args) {
        Solution demo = new Solution();

        System.out.println(demo.validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9,4}));

    }

    static class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length < 3) return false;
            int cur = 0;
            while (cur < A.length - 1 && A[cur] <= A[cur + 1]) {
                if (A[cur] == A[cur + 1]) return false;
                cur++;
            }
            if (cur == 0 || cur == A.length - 1) return false;

            int right = cur + 1;

            while (right < A.length) {
                if (A[right] >= A[right - 1]) return false;
                right++;
            }

            return true;
        }
    }

}
