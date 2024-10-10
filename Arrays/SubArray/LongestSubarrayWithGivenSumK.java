import java.util.*;

public class LongestSubarrayWithGivenSumK{

    //Brute Force 
    //Time Complexity: O(n^3)

    //Better Approch
    //Time Complexity: O(n^2)

    //Using hash map and prefix sum 
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int subarraySum(int arr[], long k){
        long sum=0;
        int maxLength = 0;
        Map<Long, Integer> map = new HashMap<>();pm

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum==k){
                maxLength = Math.max(maxLength, i+1);
            }

            long rem = sum - k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLength = Math.max(maxLength, len);
            }

            //to make it work if arr contain negative elements
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;

    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {2,0,0,3};
        System.out.print(subarraySum(arr, 3));
    }
}