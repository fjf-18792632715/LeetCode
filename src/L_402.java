public class L_402 {

    public static void main(String[] args) {
        L_402 demo = new L_402();
        String s = demo.removeKdigits("1234567890", 9);
        System.out.println(s);
    }


    // 这题坑很多。。。
    public String removeKdigits(String num, int k) {

        if (num.length() == k) return "0";

        StringBuilder sb = new StringBuilder(num);
        int count = 0;
        int index = 0;
        while (index < sb.length() - 1 && count < k) {
            // 一定要大于，不能等于，万一遇到更大的呢
            if (sb.charAt(index) > sb.charAt(index + 1)) {
                sb.deleteCharAt(index);
                count++;
                // 必须判断，因为如果是第一位就越界了
                if (index > 0) {
                    // 不进行‘--’的话，如果一直升序到最后来个小的，那么后续因为删除不够而从后开始删，例子：1234567890， 3
                    index--;
                }
            } else {
                index++;
            }
        }

        // 如果没有删除够，那就从后开始删除
        if (count < k) {
            int temp = k - count;
            for (int i = 0; i < temp; i++) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        // 剔除掉在前面的0
        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
            // 如果整个字符串都是0，那就直接return 0，不然会在下一轮判断越界
            if (sb.length() == 0) return "0";
        }

        return sb.toString();
    }

}
