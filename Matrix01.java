// Time Complexity : O (m + n)
// Space Complexity : O (m + n)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

// Do a BFS starting from all the 0s in the queue
// for each level, increase the distance by 1
public class Matrix01 {
    class Pair {
        int r, c;
        Pair(int row, int col) {
            r = row;
            c = col;
        }
    }
    Pair[] dirs = {new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1)};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int i, j;
        // add all 0s to the BFS queue
        // mark all 1s unvisited (-1)
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(mat[i][j] == 0) queue.add(new Pair(i, j));
                else mat[i][j] = -1;
            }
        }
        int level = 0;
        // Do BFS
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(i = 0; i < size; i++) {
                Pair curr = queue.poll();
                for(Pair dir: dirs) {
                    Pair nb = new Pair(curr.r + dir.r, curr.c + dir.c);
                    if (nb.r >= 0 && nb.r < m && nb.c >= 0 && nb.c < n && mat[nb.r][nb.c] == -1) {
                        //each cell in this level is (level + 1) distance away from the first level
                        mat[nb.r][nb.c] = level + 1;
                        queue.add(nb);
                    }
                }
            }
            level++;
        }
        return mat;
    }
}
