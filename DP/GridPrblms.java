public class GridPrblms {
    public static void minPath(int[][] grid, int i, int j, int row, int col, int val, int[] res) {
        if (i == row && j == col) {
            val += grid[i][j];
            return;
        }

        if (i > row || j > col) {
            return;
        }

        val += grid[i][j];

        minPath(grid, i + 1, j, row, col, val, res);
        minPath(grid, i, j + 1, row, col, val, res);
    }

    public static int minPath(int[][] grid, int i, int j, int row, int col, int[][] dp) {
        if (i == row && j == col) {
            return grid[i][j];
        }

        if (i > row || j > col) {
            return 200 * row * col;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int down = grid[i][j] + minPath(grid, i + 1, j, row, col, dp);
        int left = grid[i][j] + minPath(grid, i, j + 1, row, col, dp);

        return dp[i][j] = Math.min(down, left);

    }

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        return minPath(grid, 0, 0, m - 1, n - 1, dp);
    }

    public static void triangle(int[][] arr, int i, int j, int val, int row) {
        if (i == row) {
            val += arr[i][j];
            System.out.println(val);
            return;
        }

        val += arr[i][j];

        triangle(arr, i + 1, j, val, row);

        if (j + 1 < arr[i + 1].length) {
            triangle(arr, i + 1, j + 1, val, row);
        }
    }

    public static int triangle2(int[][] arr, int i, int j, int val, int row) {
        if (i == row) {
            return arr[i][j];
        }

        int down = arr[i][j] + triangle2(arr, i + 1, j, val, row);
        int diag = arr[i][j];
        if (j + 1 < arr[i + 1].length) {
            diag = arr[i][j] + triangle2(arr, i + 1, j + 1, val, row);
        }
        return Math.min(down, diag);
    }

    public static void main(String args[]) {
        // int[][] arr = { { 1, 3, 1 },
        // { 1, 5, 1 },
        // { 4, 2, 1 } };

        // int row = arr.length - 1;
        // int col = arr[0].length - 1;

        // int res[] = { 0 };
        // minPath(arr, 0, 0, row, col, 0, res);

        // ____________________________________

        // int[][] arr = { { 9, 1, 4, 8 } };

        // System.out.println(minPathSum(arr));

        // ____________________________________

        int[][] arr = {
                { 1 },
                { 2, 3 },
                { 3, 6, 7 },
                { 8, 9, 6, 10 }
        };
        int n = arr.length;
        System.out.println(triangle2(arr, 0, 0, 0, n - 1));

    }
}

/*
 * 
 */