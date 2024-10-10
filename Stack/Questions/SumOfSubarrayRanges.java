import java.util.*;
class SumOfSubarrayRanges {

    //Question is similar to Largest rectangle area

    //in 3 pass
    //Time Complexity: O(3N) 
    //Space Complexity: O(N)
    public static long subArrayMin(int[] nums) {
        int n=nums.length;
        int [] leftSmaller = new int[n];
        int [] rightSmaller = new int[n];
        long sum=0;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])
                st.pop();
            leftSmaller[i]= st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
                st.pop();
            rightSmaller[i]= st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        for(int i=0; i<n; i++){
            int left = i-leftSmaller[i];
            int right = rightSmaller[i]-i;
            sum+= (long)nums[i] *left *right;
        }
        return sum;
    }

    public static long subArrayMax(int[] nums) {
        int n=nums.length;
        int [] leftLarger = new int[n];
        int [] rightLarger = new int[n];
        long sum=0;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i])
                st.pop();
            leftLarger[i]= st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i])
                st.pop();
            rightLarger[i]= st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        for(int i=0; i<n; i++){
            int left = i-leftLarger[i];
            int right = rightLarger[i]-i;
            sum+= (long)nums[i] *left *right;
        }
        return sum;
    }

    public static long sumOfSubarrayRangessBy3Pass(int[] nums) {
        return subArrayMax(nums) - subArrayMin(nums);
    }


    //In one pass
    //Time Complexity: O(N) 
    //Space Complexity: O(N)    
    public static int SumOfSubarrayRangessByOnePass(int[] arr) {
        long mod=1000000007;
        Stack<Integer> st = new Stack<>();
        long sum=0;
        for(int i=0; i<=arr.length; i++){
            while(!st.isEmpty() && (i==arr.length || arr[st.peek()]>arr[i])){
                int element = st.pop();
                int leftWidth = st.isEmpty() ? -1 : st.peek(); 

                sum+=(long) arr[element] * (i-element) * (element-leftWidth);

            }
            st.push(i);
        }
        return (int)(sum%mod);
    }

    public static void main(String args[]){
        System.out.println(sumOfSubarrayRangessBy3Pass(new int[]{3,1,2,4}));
    }
}