import java.util.Arrays;

public class L_976 {

    public static void main(String[] args) {
        L_976 demo = new L_976();
        System.out.println(demo.largestPerimeter(new int[]{3, 2, 1, 2}));
    }

    public int largestPerimeter(int[] A) {

        if (A.length < 3) return 0;

        Arrays.sort(A);

        for (int i = A.length - 1; i > 1; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }

        return 0;

    }

}
