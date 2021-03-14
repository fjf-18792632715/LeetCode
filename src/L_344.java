public class L_344 {
    public void reverseString(char[] s) {
        if (s.length < 2) return;

        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }
}
