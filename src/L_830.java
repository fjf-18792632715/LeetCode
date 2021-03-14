import java.util.ArrayList;
import java.util.List;

public class L_830 {

    public static void main(String[] args) {
        L_830 demo = new L_830();
        List<List<Integer>> lists = demo.largeGroupPositions("abaaab");
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();

        int index = 0;

        while (index < s.length()) {
            int start = index;
            char temp = s.charAt(index++);
            while (index < s.length() && temp == s.charAt(index)) index++;
            index--;

            if (index - start + 1 >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(index);
                res.add(list);
            }
            index++;
        }

        return res;
    }

}
