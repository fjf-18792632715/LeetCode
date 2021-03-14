
import java.util.Arrays;
import java.util.Comparator;

public class L_406 {

    public static void main(String[] args) {
        L_406 demo = new L_406();
        int[][] array = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] queue = demo.reconstructQueue(array);
        System.out.println("------------------------------");
        for (int[] ints : queue) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] reconstructQueue(int[][] people) {

        if (people.length == 0) return new int[people.length][];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        System.out.println("========================");
        for (int[] ints : people) {
            System.out.println(Arrays.toString(ints));
        }
        int[][] res = new int[people.length][people[0].length];
        for (int[] re : res) {
            Arrays.fill(re, -1);
        }

        int hight;
        int k;
        for (int[] person : people) {
            hight = person[0];
            k = person[1];
            for (int i = 0; i < res.length; i++) {
                if (k == 0 && res[i][0] == -1) {
                    res[i][0] = hight;
                    res[i][1] = person[1];
                    break;
                }
                if (res[i][0] == -1 || res[i][0] == hight) k--;
            }
        }

        return res;
    }

}
