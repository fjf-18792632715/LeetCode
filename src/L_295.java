import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 */

public class L_295 {

    private int count;
    private PriorityQueue<Integer> priorityQueue;

    /** initialize your data structure here. */
    public L_295() {
        count = 0;
        priorityQueue = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        count++;
        priorityQueue.offer(num);
    }

    public double findMedian() {
//        Integer[] array = priorityQueue.toArray(new Integer[count]);
        int[] array = new int[count];
        int k = 0;
        for (Integer integer : priorityQueue) {
            array[k] = integer;
            k++;
        }

        int temp;
        double res;
        if (count % 2 == 0) {
            temp = count >> 1;
            res = (array[temp] + array[temp - 1]) / 2;
        } else {
            temp = count >> 1;
            res = array[temp];
        }
        return res;
    }
}
