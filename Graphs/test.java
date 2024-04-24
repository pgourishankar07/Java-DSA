import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class test {
    public static void main(String args[]) {
        String str = "hot";

        // System.out.println(str.substring(0, 0) + str.substring(1));
        // System.out.println(str.substring(0, 1) + str.substring(2));
        // System.out.println(str.substring(0, 2) + str.substring(3));
        // for (int i = 0; i < str.length(); i++) {
        // System.out.println(str.substring(i) + str.substring());
        // }
        for (int i = 0; i < str.length(); i++) {
            StringBuilder strB = new StringBuilder(str.substring(0, i) + str.substring(i + 1));
            for (char c = 'a'; c <= 'z'; c++) {
                strB.insert(i, c);
                System.out.println(strB.toString());
                strB.deleteCharAt(i);
            }
        }

    }
}

class Solution {

    public static class wtComparator implements Comparator<int[]> {
        public int compare(int a[], int b[]) {
            return a[0] - b[0];
        }
    }

    public int minimumEffortPath(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new wtComparator());

        int dist[][] = new int[n][m];
        for (var a : dist)
            Arrays.fill(a, Integer.MAX_VALUE);
        dist[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 });

        int dx[] = { 0, 0, 1, -1 };
        int dy[] = { 1, -1, 0, 0 };

        while (pq.size() != 0) {
            int a[] = pq.remove();
            int x = a[1];
            int y = a[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int newdist = Math.max(a[0], Math.abs(arr[x][y] - arr[nx][ny]));
                    if (newdist < dist[nx][ny]) {
                        dist[nx][ny] = newdist;
                        pq.add(new int[] { newdist, nx, ny });
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}