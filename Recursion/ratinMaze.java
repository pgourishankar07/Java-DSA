public class ratinMaze {

    public static int countPath(int[][] arr, int i, int j, int r, int c, int[][] res) {

        // base condition__________________________
        if (i == r || j == c || arr[i][j] == 0) {
            return 0;
        }
        if (i == r - 1 && j == c - 1) {
            res[i][j] = 1; // to print the destination path
            return 1;
        }
        // ________________________________________

        res[i][j] = 1; // to track all the paths taken by the rat

        int down = countPath(arr, i + 1, j, r, c, res);
        int right = countPath(arr, i, j + 1, r, c, res);

        if (down != 1 && right != 1) { // printing the exact path
            res[i][j] = 0;
        }

        return down + right;
    }

    public static void main(String args[]) {

        int[][] arr = {
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 1, 0, 1, 0 },
                { 1, 0, 0, 1, 1 },
                { 1, 1, 1, 0, 1 }
        };

        int r = arr.length;
        int c = arr[0].length;

        int[][] res = new int[r][c];

        System.out.println(countPath(arr, 0, 0, r, c, res));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }
}
