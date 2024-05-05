public class CherryPick {

    public static int cherryPick(int[][] grid, int i, int j1, int j2, int r, int c, int[][][] dp) {

        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c)
            return -20000;

        if (i == r - 1) { // give cherry to any one of the person if they are in same cell
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != 0)
            return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {

                int val = 0;

                if (j1 == j2)// add cherry to any one of the person if they are in same cell
                    val = grid[i][j1] + cherryPick(grid, i + 1, j1 + di, j2 + dj, r, c, dp);
                else
                    val = grid[i][j1] + grid[i][j2] + cherryPick(grid, i + 1, j1 + di, j2 + dj, r, c, dp);

                maxi = Math.max(maxi, val);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    public static void main(String args[]) {
        int grid[][] = {
                { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 } };
        int r = grid.length;
        int c = grid[0].length;

        int dp[][][] = new int[r][c][c];

        // for (int i[][] : dp) {
        // for (int j[] : i) {
        // Arrays.fill(j, -1);
        // }
        // }

        System.out.println(cherryPick(grid, 0, 0, c - 1, r, c, dp));
    }

}
