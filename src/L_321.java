import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class L_321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<Integer> array1 = topK(nums1, k);
        List<Integer> array2 = topK(nums2, k);
        List<Integer> res = new ArrayList<>();

        List<Integer> temp = new ArrayList<>(array1);
        temp.addAll(array2);

        temp.sort((o1, o2) -> o2 - o1);

        return null;
    }

    public List<Integer> topK(int[] array, int k) {
        List<Integer> list = new ArrayList<>();
        if (array.length < k) {
            for (int i : array) {
                list.add(i);
            }
            return list;
        }
        int kTh = kth(array, k);
        for (int i : array) {
            if (i >= kTh) list.add(i);
        }

        while (list.size() > k) {
            list.remove(list.indexOf(kTh));
        }

        return list;
    }

    public int kth(int[] array, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i : array) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(i);
            } else {
                if (i > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(i);
                }
            }
        }

        return priorityQueue.peek();
    }

}
