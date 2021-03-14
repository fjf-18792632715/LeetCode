public class L_1013 {

    public static void main(String[] args) {
        L_1013 demo = new L_1013();
        System.out.println(demo.canThreePartsEqualSum(new int[]{10,-10,10,-10,10,-10,10,-10}));
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        if (sum % 3 != 0) return false;
        int number = sum / 3;
        sum = 0;
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (k < 3 && sum == number) {
                k++;
                sum = 0;
            }
        }

        return k == 3 && sum == 0;
    }
}
