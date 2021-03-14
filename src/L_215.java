import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedMap;

public class L_215 {

    // 数组中第K个最大元素

    // Arrays.sort()方法排序
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 使用优先级队列(容量为K的小顶堆)
    public int findKthLargest1(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (queue.size() < k) {
                queue.offer(temp);
            } else {
                if (temp > queue.peek()) {
                    queue.offer(temp);
                    queue.poll();
                }
            }
        }

        return queue.poll();

    }
}
