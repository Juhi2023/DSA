import java.util.*;

class OnlineStockSpan{

    //Brute Force
    //Time Complexity: O(N^2) 
    //Space Complexity: O(1)

    //Using Stack
    //Time Complexity: O(N) 
    //Space Complexity: O(N)
    public static void stockSpan(int arr[]){
        Stack<Integer> st = new Stack<>();
        int span[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty())
                span[i] = i+1;
            else{
                int prevHigh = st.peek();
                span[i] = i-prevHigh;
            } 
                

            st.push(i);
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(span[i]+" ");
        }
    }

    public static void main(String args[]){
        stockSpan(new int[]{100, 80, 60, 70, 60, 85, 100});
    }
}