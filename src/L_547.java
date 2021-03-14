import java.util.Arrays;

public class L_547 {

    // bfs 广度优先遍历


    // dfs 深度优先遍历
    public int findCircleNum(int[][] isConnected) {
        int number = isConnected.length;
        boolean[] flag = new boolean[number]; // 默认 false
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!flag[i]){
                flag[i] = true;
                dfs(isConnected, flag, number, i);
                count++;
            }
        }

        return count;
    }

    public void dfs(int[][] isConnected, boolean[] flag, int number, int i){
        for (int j = 0; j < number; j++) {
            if (isConnected[i][j] == 1 && !flag[j]) {
                flag[j] = true;
                dfs(isConnected, flag, number, j);
            }
        }
    }

}
