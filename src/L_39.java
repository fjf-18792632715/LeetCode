import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class L_39 {

    public static void main(String[] args) {
        L_39 demo = new L_39();
        System.out.println(demo.combinationSum(new int[]{7,3,2}, 18));
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
/*
        int size = candidates.length;

        int[] array = new int[target * size];

        for (int i = 0; i < target; i++) {
            for (int j = 0; j < size; j++) {
                array[i * size + j] = candidates[j];
            }
        }

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        Method(0, target, array, target * size);
*/
        Date data1 = new Date();

        //Arrays.sort(candidates);
        Method(0, target, candidates);

        Date data2 = new Date();
        System.out.println("time:" + (data2.getTime() - data1.getTime()));

        return res;

    }

    public void Method(int start, int target, int[] candidates) {
        if(sum(list) > target){
            return;
        }
        if(sum(list) == target){
            if (res.contains(list)){
                return;
            }
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++ ) {
            list.add(candidates[i]);
            Method(i, target, candidates);
            list.remove(list.size() - 1);
        }
    }

    public int sum(List<Integer> list) {
        int temp = 0;
        for (Integer integer: list) {
            temp += integer;
        }

        return temp;
    }
}
