import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 60. 第k个排列
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

     按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     给定 n 和 k，返回第 k 个排列。

     说明：

     给定 n 的范围是 [1, 9]。
     给定 k 的范围是[1,  n!]。


 */

public class L_60 {
    public static void main(String[] args) {
        L_60 l_60 = new L_60();
        String permutation = l_60.getPermutation(4, 15);
        System.out.println(permutation);
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("123");
//        arrayList.add("456");
//
//        int[] array = {1,2,3,4,5,6};
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < array.length; i++) {
//            stringBuilder.append(array[i]);
//        }
//        arrayList.add(stringBuilder.toString());
//        System.out.println(arrayList);
    }

//    private static List<String> arrayList = new ArrayList<>();

    public String getPermutation(int n, int k) {
        ArrayList<String> arrayList = new ArrayList<>();
        int[] chars = new int[n];
        for (int i = 1; i <= n; i++) {
            chars[i - 1] = i;
        }

//        System.out.println(Arrays.toString(chars));

        Permutation(chars, 0, arrayList);

//        System.out.println(arrayList);

        Object[] strings = arrayList.toArray();

        Arrays.sort(strings);

//        System.out.println(Arrays.toString(strings));

        return (String) strings[k - 1];
    }

    public void Permutation(int[] chars, int start, ArrayList<String> arrayList) {
        if (start == chars.length - 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                stringBuilder.append(chars[i]);
            }
            arrayList.add(stringBuilder.toString());
        }
        for (int i = start; i <= chars.length - 1; i++) {

            if (start == i || chars[start] != chars[i]) {
                swap(chars, i, start);
                Permutation(chars, start + 1, arrayList);
                swap(chars, i, start);
            }

        }
    }

    public void swap(int[] chars, int i, int j) {
        int temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
