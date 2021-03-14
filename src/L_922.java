import java.util.Arrays;

public class L_922 {

    public static void main(String[] args) {
        L_922 demo = new L_922();
        int[] ints = demo.sortArrayByParityII(new int[]{4, 2, 5, 7,6,22,7,7,8,3,34,35,3,12});
        System.out.println(Arrays.toString(ints));
    }


    public int[] sortArrayByParityII(int[] A) {
        int leftIndex = 0;
        int rightIndex = A.length - 1;

        // 搞成 左偶数，右奇数
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && A[leftIndex] % 2 == 1) leftIndex++;
            while (leftIndex < rightIndex && A[rightIndex] % 2 == 0) rightIndex--;
            if (leftIndex !=  rightIndex) {
                A[leftIndex] ^= A[rightIndex];
                A[rightIndex] ^= A[leftIndex];
                A[leftIndex] ^= A[rightIndex];
            }
        }

        leftIndex = 0;
        rightIndex = A.length - 1;

        while (leftIndex < rightIndex) {
            A[leftIndex] ^= A[rightIndex];
            A[rightIndex] ^= A[leftIndex];
            A[leftIndex] ^= A[rightIndex];
            leftIndex += 2;
            rightIndex -= 2;
        }

        return A;
    }



}
