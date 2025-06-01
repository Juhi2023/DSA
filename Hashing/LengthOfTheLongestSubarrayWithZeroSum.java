import java.util.*;

public class LengthOfTheLongestSubarrayWithZeroSum{

    //Brute Force 
    //Time Complexity: O(n^3)

    //Better Approch
    //Time Complexity: O(n^2)

    //Using hash map and prefix sum 
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int longestSubArray(int arr[]){
        int max=0;
        long sum=0;
        Map<Long, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];

            if(sum==0){
                max =i+1;
            }else{
                if(map.containsKey(sum)){
                    max = Math.max(max, i - map.get(sum)); 
                }else{
                    map.put(sum, i);
                }
            }
        }
        return max;

    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {2,0,0,3};
        System.out.print(longestSubArray(arr));
    }
}