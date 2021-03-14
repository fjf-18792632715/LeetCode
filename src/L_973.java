import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L_973 {

    public static void main(String[] args) {
        L_973 demo = new L_973();
        int[][] ints = demo.kClosest3(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    /*
            执行用时：32 ms, 在所有 Java 提交中击败了53.92%的用户
            内存消耗：45.6 MB, 在所有 Java 提交中击败了99.27%的用户
     */
    // 方法三：优化优先级队列（大根堆），不用在堆内部插入的时候每次比较都计算一次size
    public int[][] kClosest3(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < points.length; i++) {
            if (i < K) {
                priorityQueue.offer(new int[]{size(points[i]), i});
            } else {
                int temp = size(points[i]);
                if (temp < priorityQueue.peek()[0]) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{temp, i});
                }
            }
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = points[priorityQueue.poll()[1]];
        }

        return res;
    }

    /*
            执行用时：36 ms, 在所有 Java 提交中击败了41.13%的用户
            内存消耗：47 MB, 在所有 Java 提交中击败了73.18%的用户

            实测：还不如全部插入小根堆，可能是因为多次调用size方法
     */
    // 方法二：优先级队列（大根堆），先插入K个元素，后续跟第一个元素进行比较，如果小于第一个元素那么就弹出第一个元素并且插入，否则就下一个。（效率好于小根堆）
    public int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return size(o2) - size(o1);
            }
        });

        for (int[] point : points) {
            if (priorityQueue.size() < K) {
                priorityQueue.add(point);
            } else {
                if (size(point) < size(priorityQueue.peek())) {
                    priorityQueue.poll();
                    priorityQueue.add(point);
                }
            }
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = priorityQueue.poll();
        }

        return res;
    }

    /*
        执行用时：32 ms, 在所有 Java 提交中击败了53.92%的用户
        内存消耗：46.8 MB, 在所有 Java 提交中击败了85.09%的用户
     */
    // 方法一：优先级队列（最小堆）效率中等，缺点：需要一直插入元素，不如大根堆
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return size(o1) - size(o2);
            }
        });

        // 底层还是存了 不止K个元素
        priorityQueue.addAll(Arrays.asList(points));
//        while (!priorityQueue.isEmpty()) {
//            System.out.println(Arrays.toString(priorityQueue.poll()));
//        }

        int[][] res = new int[K][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = priorityQueue.poll();
        }

        return res;
    }

    public int size(int[] array) {
        return array[0] * array[0] + array[1] * array[1];
    }
}
