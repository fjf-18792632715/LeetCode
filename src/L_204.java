public class L_204 {
    public static void main(String[] args) {
        L_204 demo = new L_204();
        System.out.println(demo.countPrimes(499979));
    }
    // 自动忽略暴力

    // 方法1：埃氏筛
    public int countPrimes(int n) {
        if (n < 2) return 0;
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 1;
        int count = 0;

        for (int i = 2; i < array.length; i++) {
            if (array[i] == 0) {

                array[i] = 1;
                count++;
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        array[j] = 1;
                    }
                }

            }
        }

        return count;

    }

    public boolean isTrue(int number) {
        for (int i = 2; i * i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}
