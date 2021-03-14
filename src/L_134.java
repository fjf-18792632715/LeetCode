public class L_134 {

    public static void main(String[] args) {
        L_134 demo = new L_134();
        System.out.println(demo.canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int size = gas.length;
        for (int i = 0; i < size; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumGas < sumCost) return -1;

        for (int i = 0; i < size; i++) {
            int temp = size;
            int index = i;
            int sum = 0;
            while (temp > 0) {
                sum += gas[index];
                if (sum < cost[index]) {
                    break;
                }
                sum -= cost[index];
                index++;
                index %= size;
                temp--;
            }

            if (temp == 0) {
                return i;
            } else {
                i += size - temp;
                i %= size;
            }
        }

        return -1;
    }

}
