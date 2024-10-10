import java.util.*;
class SumOfSubarrayMinimums {

    //Question is similar to Largest rectangle area

    //in 3 pass
    //Time Complexity: O(3N) 
    //Space Complexity: O(N)
    public static int sumSubarrayMinsBy3Pass(int[] arr) {
        long mod=1000000007;
        int n=arr.length;
        int leftSmaller[] = new int[n];
        int rightSmaller[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            leftSmaller[i]= st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        while (!st.isEmpty()) st.pop();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            rightSmaller[i]= st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long sum=0;
        for(int i=0; i<n; i++){
            int left = i - leftSmaller[i];
            int right = rightSmaller[i]-i;
            sum += (long)arr[i] * left * right;
        }

        return (int)(sum%mod);
    }

    //In one pass
    //Time Complexity: O(N) 
    //Space Complexity: O(N)    
    public static long sumSubarrayMinsByOnePass(int[] arr) {
        int n=nums.length;
        long min=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i==n || nums[st.peek()]>nums[i])){
                int elementIndex = st.pop();
                int leftIndex = st.isEmpty() ? -1 : st.peek();
                min+= (long)nums[elementIndex] * (elementIndex-leftIndex) * (i-elementIndex);
            }
            st.push(i);
        }

        int n=nums.length;
        long max=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i==n || nums[st.peek()]<nums[i])){
                int elementIndex = st.pop();
                int leftIndex = st.isEmpty() ? -1 : st.peek();
                max+= (long)nums[elementIndex] * (elementIndex-leftIndex) * (i-elementIndex);
            }
            st.push(i);
        }

        return max-min;
    }

    public static void main(String args[]){
        System.out.println(sumSubarrayMinsByOnePass(new int[]{3,1,2,4}));
    }
}