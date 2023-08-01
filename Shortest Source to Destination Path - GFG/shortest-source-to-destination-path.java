//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {

    // tuple class to store cell coordinates with their distance
    class Tuple {
        int dist;
        int row;
        int col;

        public Tuple(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, source[0], source[1]));
        visited[source[0]][source[1]] = true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int dis = it.dist;
            int r = it.row;
            int c = it.col;

            if (r == destination[0] && c == destination[1]) {
                return dis;
            }

            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m && !visited[newr][newc] && grid[newr][newc] == 1) {
                    q.add(new Tuple(dis + 1, newr, newc));
                    visited[newr][newc] = true;
                }
            }
        }

        return -1;
    }

    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = A[i][j];
            }
        }

        int[] source = {0, 0};
        int[] destination = {X, Y};

        return shortestPath(grid, source, destination);
    }
}
