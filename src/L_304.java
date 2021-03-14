public class L_304 {
    private int[][] array;
    public L_304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        this.array = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1] - array[i - 1][j - 1] + matrix[i- 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return array[row2 + 1][col2 + 1] - array[row2 + 1][col1] - array[row1][col2 + 1] + array[row1][col1];
    }
}
