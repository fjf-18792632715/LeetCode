public class L_860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int number : bills) {
            if (number == 5) {
                five++;
            } else if (number == 10) {
                if(five == 0) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (ten == 0) {
                    if (five >= 3) {
                        five -= 3;
                    } else return false;
                } else{
                    return false;
                }
            }
        }

        return true;
    }
}
