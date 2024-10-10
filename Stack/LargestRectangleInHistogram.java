 import java.util.*;

public class LargestRectangleInHistogram{
    //2 passess
    //Time Complexity: O(3N)
    public static void getLargestArea(int height[]){
        int n=height.length;
        int leftSmaller[] = new int[n];
        int rightSmaller[] = new int[n];

        //calcuate left  samller index
        Stack<Integer> st = new Stack<>();
        for(int i=0; i< n; i++){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();
            }
            leftSmaller[i] = st.isEmpty() ? 0 : st.peek()+1;
            st.push(i);
        }

        while (!st.isEmpty()) st.pop();

        //calcuate right  samller index
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();
            }
            rightSmaller[i] = st.isEmpty() ? n-1 : st.peek()-1;
            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, height[i] * (rightSmaller[i] - leftSmaller[i] + 1));
        }

        System.out.println("Area: "+maxA);
    }

    public static void getLargestAreaBySinglePass(int heights[]){
      Stack < Integer > st = new Stack < > ();
        int maxA = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
    }

    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int[] arr = {4, 1, 2, 5, 6, 3, 4};
        getLargestArea(arr);
    }
}