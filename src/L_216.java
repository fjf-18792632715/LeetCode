import java.util.ArrayList;
import java.util.List;

public class L_216 {
    public static void main(String[] args) {

        L_216 demo = new L_216();
        System.out.println(demo.combinationSum3(3, 7));

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        int[] array = new int[9];
        for (int i = 1; i <= array.length; i++) {
            array[i - 1] = i;
        }

        Method(0, array, k, n);

        return res;

    }

    public void Method(int start, int[] array, int k, int n) {
        if (list.size() == k || sum(list) > n) {
            if (sum(list) == n) {
                res.add(new ArrayList<>(list));
                return;
            } else {
                return;
            }
        }

        for (int i = start; i < 9; i++) {
            list.add(array[i]);
            if (sum(list) > n) {
                list.remove(list.size() - 1);
                return;
            }
            Method(i + 1, array, k, n);
            list.remove(list.size() - 1);
        }
    }

    private int sum(List<Integer> list) {
        int temp = 0;
        for (Integer integer : list) {
            temp += integer;
        }

        return temp;
    }
}
