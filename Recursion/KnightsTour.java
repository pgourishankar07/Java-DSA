public class KnightsTour {

    static int N = 8; // chess Board size

    public static void printSolution(int solu[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(solu[x][y] + " ");
            System.out.println();
        }
    }

    public static boolean isVisited(int x, int y, int board[][]) { // move should be inside the board and not visited
                                                                   // position
        if (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1) {
            return false;
        }

        return true;
    }

    public static boolean helper(int x, int y, int pos, int[][] solu, int xMove[], int yMove[]) {

        if (pos == N * N) {
            return true;
        }

        for (int k = 0; k < 8; k++) { // placing each combination of moves
            int nextX = x + xMove[k];
            int nextY = y + yMove[k];

            if (!isVisited(nextX, nextY, solu)) {
                solu[nextX][nextY] = pos;
                if (helper(nextX, nextY, pos + 1, solu, xMove, yMove)) {
                    return true;
                } else {
                    solu[nextX][nextY] = -1; // backtracking
                }
            }
        }

        return false;

    }

    public static void main(String args[]) {

        int solu[][] = new int[N][N];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                solu[x][y] = -1;
            }
        }
        solu[0][0] = 0; // knight starting point

        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 }; // 2 + 1 == --|
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        if (!helper(0, 0, 1, solu, xMove, yMove)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution(solu);
        }
    }
}

// Time Complexity : N^(N^2)
