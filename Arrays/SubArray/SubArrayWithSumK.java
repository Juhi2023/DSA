import java.util.*;

public class SubArrayWithSumK{

    //Brute Force 
    //Time Complexity: O(n^3)

    //Better Approch
    //Time Complexity: O(n^2)

    //Using hash map and prefix sum 
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int subarraySum(int arr[], long k){
        int count=0;
        long sum=0;
        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];

            long rem = sum - k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {2,0,0,3};
        System.out.print(subarraySum(arr, 3));
    }
}