public class countPaths {

    public static int countPath(int i, int j, int r, int c) {
        if (i == r || j == c) {
            return 0;
        }
        if (i == r - 1 && j == c - 1) {
            return 1;
        }

        int down = countPath(i + 1, j, r, c);
        int right = countPath(i, j + 1, r, c);

        return down + right;
    }

    public static void main(String args[]) {
        int start = 0;
        int end = 0;
        int rows = 3;
        int columns = 3;
        System.out.println(countPath(start, end, rows, columns));

    }
}

// you can only move downwards and rightwards
// inital index : start,end -- where u going to start
// final index : rows,columns -- where u want to reach