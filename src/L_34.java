public class L_34 {

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        boolean flag = false;

        if (nums.length == 0) return new int[]{-1,-1};
        int[] res = new int[2];
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                flag = true;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (flag) {
            int left = mid;
            int right = mid;
            while (left > 0 && nums[left - 1] == target) left--;
            while (right < nums.length - 1 && nums[right + 1] == target) right++;
            res[0] = left;
            res[1] = right;
            return res;
        }

        if (nums[start] == target) {
            res[0] = start;
            res[1] = start;
        } else {
            res[0] = -1;
            res[1] = -1;
        }

        return res;
    }

}
