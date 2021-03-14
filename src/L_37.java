import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解数独
 */

public class L_37 {
    public static void main(String[] args) {
//        List<Character> list = new ArrayList<>();
//        list.add('1');
//        list.add('2');
//        list.add('3');
//        list.add('4');
//        list.add('5');
//        list.add('6');
//        list.add('7');
//        list.add('8');
//        list.add('9');
//
//        char[] array = {'3', '4', '5', '6'};
//        for (int i = 0; i < array.length; i++) {
//            char temp = array[i];
//            if (list.contains(temp)) {
//                list.remove(list.indexOf(temp));
//            }
//        }
//
//        System.out.println(list);
//        [   ["5","3",".",".","7",".",".",".","."],
//            ["6",".",".","1","9","5",".",".","."],
//            [".","9","8",".",".",".",".","6","."],
//            ["8",".",".",".","6",".",".",".","3"],
//            ["4",".",".","8",".","3",".",".","1"],
//            ["7",".",".",".","2",".",".",".","6"],
//            [".","6",".",".",".",".","2","8","."],
//            [".",".",".","4","1","9",".",".","5"],
//            [".",".",".",".","8",".",".","7","9"]   ]

        L_37 demo = new L_37();
        char[][] array = {  {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};

        demo.solveSudoku(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

    }

    public void solveSudoku(char[][] board) {
        int x = 0;
        int y = 0;
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    x = i;
                    y = j;
                    flag = true;
                    break;
                }
            }

            if (flag) break;
        }

        List<Character> list = getList(x, y, board);
        char[] array = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        for (int i = 0; i < array.length; i++) {
            board[x][y] = array[i];
            Method(x, y, board);
        }

    }

    public void Method(int curX, int curY, char[][] board) {
        if (board[curX][curY] != '.') {
            if (curY < board.length && curX == board.length - 1) {
                curX = 0;
                curY += 1;
                Method(curX, curY, board);
            } else if (curY == board.length - 1 && curX == board.length - 1) {
                return;
            } else {
                curX += 1;
                Method(curX, curY, board);
            }
        } else {
            List<Character> list = getList(curX, curY, board);
            if (list.size() == 0) return;
            for (Character character : list) {
                board[curX][curY] = character;
                Method(curX, curY, board);
            }
        }
    }

    public List<Character> getList (int x, int y, char[][] board) {
//        char[] array = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        ArrayList<Character> list = new ArrayList<>();
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');

        for (int i = 0; i < board.length; i++) {
            char temp = board[x][i];
            if (list.contains(temp))  list.remove(list.indexOf(temp));
        }

        for (int i = 0; i < board.length; i++) {
            char temp = board[i][y];
            if (list.contains(temp))  list.remove(list.indexOf(temp));
        }

        x /= 3;
        y /= 3;

        for (int i = x * 3; i < x * 3 + 3; i++) {
            for (int j = y * 3; j < y * 3 + 3; j++) {
                char temp = board[i][j];
                if (list.contains(temp))  list.remove(list.indexOf(temp));
            }
        }

        return list;
    }

}
