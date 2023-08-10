//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int K;
            K = sc.nextInt();

            int N;
            N = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.combinationSum(K, N);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            for (int i = 0; i < ans.size(); i++) {
                ArrayList<Integer> cur = ans.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    System.out.print(cur.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    private static void funchelper(int ind, int sum, int N, ArrayList<ArrayList<Integer>> ansList, ArrayList<Integer> ds, int K) {
        if (sum == N && K == 0) {
            ansList.add(new ArrayList<>(ds));
            return;
        }
        if (sum > N || K == 0) {
            return;
        }
        
        for (int i = ind; i <= 9; i++) { // We assume the range is from 1 to 9, you can adjust as needed.
            ds.add(i);
            funchelper(i + 1, sum + i, N, ansList, ds, K - 1);
            ds.remove(ds.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        funchelper(1, 0, N, ansList, new ArrayList<>(), K);
        return ansList;
    }
}
