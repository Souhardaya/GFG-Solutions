//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends





class Solution {
    private int ROWS, COLS;
    private Set<Integer> path;

    public boolean isWordExist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        path = new HashSet<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (findWords(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWords(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || word.charAt(i) != board[r][c] || path.contains(r * COLS + c)) {
            return false;
        }
        path.add(r * COLS + c);

        boolean res = (findWords(board, word, r + 1, c, i + 1) ||
                findWords(board, word, r - 1, c, i + 1) ||
                findWords(board, word, r, c + 1, i + 1) ||
                findWords(board, word, r, c - 1, i + 1));
        path.remove(r * COLS + c);
        return res;
    }
}


