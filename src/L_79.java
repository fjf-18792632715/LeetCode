import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 79. 单词搜索
 */

public class L_79 {
    public static void main(String[] args) {
        L_79 demo = new L_79();
        char[][] chars;
        chars = new char[][]{{'a', 'a', 'a', 'a'},
                            {'a', 'a', 'a', 'a'},
                            {'a', 'a', 'a', 'a'}};
        System.out.println(demo.exist(chars, "aaaaaaaaaaaaa"));
    }

    boolean flag = false;

    public boolean exist(char[][] board, String word) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                Method(board, word, i, j, 0);
            }
        }

        return flag;
    }

    public void Method(char[][] board, String word, int startX, int startY, int number) {
        if (board.length * board[0].length < word.length()) return;

        if (board[startX][startY] != word.charAt(number)){
            return;
        }

        if (number == word.length() - 1) {
            flag = true;
            return;
        }

        char temp = board[startX][startY];
        board[startX][startY] = '*';

        if (startX < board.length - 1 && board[startX + 1][startY] != '*') {
            Method(board, word, startX + 1, startY, number + 1);
        }

        if (startX > 0 && board[startX - 1][startY] != '*') {
            Method(board, word, startX - 1, startY, number + 1);
        }

        if (startY < board[0].length - 1 && board[startX][startY + 1] != '*') {
            Method(board, word, startX, startY + 1, number + 1);
        }

        if (startY > 0 && board[startX][startY - 1] != '*') {
            Method(board, word, startX, startY - 1, number + 1);
        }

        board[startX][startY] = temp;
    }
}
