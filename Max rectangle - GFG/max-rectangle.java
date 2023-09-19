//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        if (M == null || n == 0 || m == 0) {
            return 0;
        }

        int maxRectangleArea = 0;
        int[] height = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    height[j]++; // Increment the height if the cell contains '1'
                } else {
                    height[j] = 0; // Reset the height to 0 if the cell contains '0'
                }
            }

            int area = maxAreaInHistogram(height); // Calculate the largest rectangle area in the histogram
            maxRectangleArea = Math.max(maxRectangleArea, area);
        }

        return maxRectangleArea;
    }

    // Helper method for calculating the largest rectangle area in a histogram
    private int maxAreaInHistogram(int[] heights) {
        int n = heights.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> st = new Stack<>();

        // Calculate left smaller elements' indices
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = st.peek() + 1;
            }
            st.push(i);
        }

        // Clear the stack
        st.clear();

        // Calculate right smaller elements' indices
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rightSmall[i] = n - 1;
            } else {
                rightSmall[i] = st.peek() - 1;
            }
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightSmall[i] - leftSmall[i] + 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}

