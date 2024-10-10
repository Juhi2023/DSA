
import java.util.*;
class NextGreaterElementII{

    //Brute Force
    //Time Complexity: O(N^2) 
    //Space Complexity: O(1)

    //Using Stack
    //Time Complexity: O(N) 
    //Space Complexity: O(N)
    public static void getNextGreaterElement(int arr[]){
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        int ans[] = new int[arr.length];

        for(int i=2*n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=arr[i%n]){
                st.pop();
            }
            if(i<n)
                ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i%n]);
        }


        for(int i=0; i<arr.length; i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static void main(String args[]){
        getNextGreaterElement(new int[]{3,10,4,2,1,2,6,1,7,2,9});
    }
}