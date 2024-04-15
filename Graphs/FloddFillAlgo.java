public class FloddFillAlgo {

    public static void dfs(int[][] image, int sr, int sc, int color, boolean[][] visi, int orgColor) {

        if (!visi[sr][sc]) {

            image[sr][sc] = color;
            visi[sr][sc] = true;

            if (sr - 1 >= 0 && image[sr - 1][sc] == orgColor) {
                dfs(image, sr - 1, sc, color, visi, orgColor);
            }

            if (sr + 1 < image.length && image[sr + 1][sc] == orgColor) {
                dfs(image, sr + 1, sc, color, visi, orgColor);
            }

            if (sc - 1 >= 0 && image[sr][sc - 1] == orgColor) {
                dfs(image, sr, sc - 1, color, visi, orgColor);
            }

            if (sc + 1 < image[0].length && image[sr][sc + 1] == orgColor) {
                dfs(image, sr, sc + 1, color, visi, orgColor);
            }
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean[][] visi = new boolean[image.length][image[0].length];

        dfs(image, sr, sc, color, visi, image[sr][sc]);

        return image;
    }
}
