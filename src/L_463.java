public class L_463 {

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        System.out.println(i);
        System.out.println(i + 1);
        System.out.println(i > i + 1);
        System.out.println(Integer.MIN_VALUE);
    }


    public int islandPerimeter(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 < 0 || i + 1 > grid.length - 1) {
                        if (i - 1 < 0 && i + 1 > grid.length - 1) {
                            count += 2;
                        }else if (i - 1 < 0) {
                            if (grid[i + 1][j] == 0) count++;
                            count++;
                        } else {
                            if (grid[i - 1][j] == 0) count++;
                            count++;
                        }
                    } else {
                        if (grid[i - 1][j] == 0) count++;
                        if (grid[i + 1][j] == 0) count++;
                    }

                    if (j - 1 < 0 || j + 1 > grid[0].length - 1) {
                        if (j - 1 < 0 && j + 1 > grid[0].length - 1) {
                            count += 2;
                        }else if (j - 1 < 0) {
                            if (grid[i][j + 1] == 0) count++;
                            count++;
                        } else {
                            if (grid[i][j - 1] == 0) count++;
                            count++;
                        }
                    } else {
                        if (grid[i][j - 1] == 0) count++;
                        if (grid[i][j + 1] == 0) count++;
                    }
                }
            }
            System.out.println(count);
        }

        return count;
    }
}
