public class L_338 {

    public int[] countBits(int num) {
        int[] array = new int[num + 1];

        array[0] = 0;

        for (int i = 1; i < array.length; i++) {
            if ((i & 1) == 1) {
                array[i] = array[i - 1] + 1;
            } else {
                array[i] = array[i / 2];
            }
        }

        return array;
    }

}
