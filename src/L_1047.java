public class L_1047 {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);
        boolean flag = false;

        while (!flag) {
            flag = true;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    flag = false;
                    sb.delete(i, i + 2);
                    i--;
                }
            }
        }

        return sb.toString();
    }

}
