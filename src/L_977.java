import java.util.Arrays;
import java.util.PriorityQueue;

public class L_977 {

    // 直接用Arrays.sort进行排序，时间复杂度 N*logN
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }

        Arrays.sort(A);
        return A;
    }

    // 使用优先级队列（小顶堆），时间空间复杂度都很高，最垃圾
    public int[] sortedSquares1(int[] A) {
        PriorityQueue<Integer> qu = new PriorityQueue<Integer>();
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
            qu.offer(A[i]);
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = qu.poll();
        }

        return A;

    }

    // 效率最高！ 使用双指针，和正负定界，往两边滑动
    public int[] sortedSquares2(int[] A) {
        int flag = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) flag = i;
            A[i] = A[i] * A[i];
        }

        if (flag < 0) {
            return A;
        } else if (flag == A.length - 1) {
            for (int i = 0; i < A.length / 2; i++) {
                A[i] ^= A[A.length - i - 1];
                A[A.length - i - 1] ^= A[i];
                A[i] ^= A[A.length - i - 1];
            }

            return A;
        } else {
            int[] array = new int[A.length];

            int left = flag;
            int right = flag + 1;
            int k = 0;
            while (left != -1 && right != A.length) {
                array[k++] = A[left] < A[right] ? A[left--] : A[right++];
            }

            if (left == -1) {
                while (right != A.length) {
                    array[k++] = A[right++];
                }
            } else {
                while (left != -1) {
                    array[k++] = A[left--];
                }
            }

            return array;
        }
    }
}
