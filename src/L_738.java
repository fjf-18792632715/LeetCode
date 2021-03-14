import java.util.Arrays;

public class L_738 {
    public static void main(String[] args) {
        L_738 demo = new L_738();
        System.out.println(demo.monotoneIncreasingDigits(668841));
    }

    public int monotoneIncreasingDigits(int N) {
        int length = (N + "").length();
        int[] array = new int[length];
        int res = 0;

        for (int i = array.length - 1; i >= 0 ; i--) {
            array[i] = N % 10;
            N /= 10;
        }

//        System.out.println(Arrays.toString(array));
        int i = 0;
        while (i < array.length - 1 && array[i] <= array[i + 1]) i++;

        if (i < array.length - 1) {
            while (i > 0 && array[i] == array[i - 1]) i--;
            array[i++]--;
            while (i < array.length) {
                array[i++] = 9;
            }
        }

        for (int j : array) {
            res *= 10;
            res += j;
        }

        return res;

    }
}
