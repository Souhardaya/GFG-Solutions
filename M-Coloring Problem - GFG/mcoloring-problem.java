//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such that no two adjacent vertices of the graph are coloured with the same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n]; // To store the color assigned to each vertex
        return graphColoringUtil(graph, color, 0, m, n);
    }

    // Recursive utility function to check if coloring is possible
    private boolean graphColoringUtil(boolean graph[][], int color[], int vertex, int m, int n) {
        if (vertex == n) {
            return true; // All vertices are colored successfully
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(vertex, graph, color, c, n)) {
                color[vertex] = c;
                if (graphColoringUtil(graph, color, vertex + 1, m, n)) {
                    return true; // Move to the next vertex
                }
                color[vertex] = 0; // Backtrack
            }
        }

        return false; // Color assignment not possible for this vertex
    }

    // Check if it's safe to color the vertex with the given color
    private boolean isSafe(int vertex, boolean graph[][], int color[], int c, int n) {
        for (int v = 0; v < n; v++) {
            if (graph[vertex][v] && color[v] == c) {
                return false; // Adjacent vertices have the same color
            }
        }
        return true; // It's safe to color the vertex with this color
    }
}
