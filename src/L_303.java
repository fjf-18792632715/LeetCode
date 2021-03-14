public class L_303 {
    public L_303(int[] nums) {
        array = new int[nums.length + 1];
        array[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            array[i] = array[i - 1] + nums[i - 1];
        }
    }
    private int[] array;
    public int sumRange(int i, int j) {
        return array[j + 1] - array[i];
    }
}
