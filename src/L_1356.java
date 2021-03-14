import java.util.*;

public class L_1356 {

    public static void main(String[] args) {
        L_1356 demo = new L_1356();
        System.out.println(Arrays.toString(demo.sortByBits(new int[]{2,3,5,7,11,13,17,19})));
    }

    // 方法一：大佬方法
    //      统计一的个数，然后乘个大数字，再加上原数字，排序之后取模运算
    public int[] sortByBits(int[] arr) {
        if (arr.length == 0) return arr;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + numberCountOne(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 100000;
        }

        return arr;
    }



    // 方法二：创建键值对对象，利用sort排序输出：效率差
    class MyEntry{
        Integer key;
        Integer value;

        public MyEntry(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public MyEntry() {
        }
    }

    public int[] sortByBits2(int[] arr) {
        List<MyEntry> list = new ArrayList<>();
        for (int i : arr) {
            list.add(new MyEntry(i, numberCountOne(i)));
        }

        list.sort(new Comparator<MyEntry>() {
            @Override
            public int compare(MyEntry o1, MyEntry o2) {
                return o1.value == o2.value ? o1.key - o2.key : o1.value - o2.value;
            }
        });

        int index = 0;
        for (MyEntry myEntry : list) {
            arr[index++] = myEntry.key;
        }

        return arr;
    }

    public int numberCountOne (int number) {
        int count = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                count++;
            }

            number >>= 1;
        }
        return count;
    }

}
