// Time Complexity : O (m x n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Comments in code
public class FloodFill {
    int[][] image;
    int startColor;
    int fillColor;
    int m, n;
    void dfs(int r, int c) {
        // if out of bounds or the pixel is not the startColor, exit the DFS
        if(r < 0 || r >= m || c < 0 || c >= n || image[r][c] != startColor) return;
        // change the pixel to the fillColor
        image[r][c] = fillColor;
        // propagate DFS to horizontal and vertical neighbors
        dfs(r - 1, c); dfs(r + 1, c);
        dfs(r, c - 1); dfs(r, c + 1);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        this.startColor = image[sr][sc];
        this.fillColor = color;
        // if startColor is same as fillColor, no change needed
        if(startColor == fillColor)
            return image;
        m = image.length;
        n = image[0].length;
        // start a DFS from the starting pixel
        dfs(sr, sc);
        return image;
    }
}
