import java.util.*;

public class SubArrayWithXorK{

    //Brute Force 
    //Time Complexity: O(n^3)

    //Better Approch
    //Time Complexity: O(n^2)

    //Using hash map and prefix sum 
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int subarrayXOR(int arr[], long k){
        int count=0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);
        long xor=0;

        for(int i=0; i<arr.length; i++){
            xor ^= arr[i];
            
            long rem = k ^ xor;
            if(map.containsKey(rem)){
                count+= map.get(rem);
            }

            map.put(xor, map.getOrDefault(xor, 0)+1);
        }

        return count;
    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {4, 2, 2, 6, 4};
        System.out.print(subarrayXOR(arr, 6));
    }
}