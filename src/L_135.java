import sun.security.util.Length;

public class L_135 {

    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];

        res[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
        }


        int temp = 1;
        int sum = Math.max(1, res[res.length - 1]);
//        res[res.length - 1] = Math.max(1, res[res.length - 1]);
        for (int i = ratings.length - 2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1]) {
                temp++;
            } else {
                temp = 1;
            }
            sum += Math.max(temp, res[i]);
        }

        return sum;
    }

}
