//Find length of the longest subarray containing atmost two distinct integers
import java.util.*;
class FruitIntoBaskets {
    
    //Brute Force
    //Time Complexity: O(N^3)
    //Space Complexity: O(1)
    public static int totalFruitBrute(int[] fruits) {
        int N=fruits.length;
        int size = 0; 
        
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                Set<Integer> distinct = new HashSet<>();
                for (int k = i; k <= j; k++) {
                    distinct.add(fruits[k]);
                    if (distinct.size() > 2) {
                        break;
                    }
                }
                if (distinct.size() <= 2) {
                    size = Math.max(size, j-i+1);
                }
            }
        }
        
        return size;
    }

    //Optimized
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int r=0;
        int l=0;
        int n=fruits.length;
        int maxF=0;
        while(r<n){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);
            while(map.size()>2){
                int fruit = fruits[l];
                map.put(fruit, map.get(fruit)-1);
                map.remove(fruit, 0);
                l++;
            }
            maxF = Math.max(maxF, r-l+1);
            r++;
        }
        return maxF;
    }

    public static void main(String [] arg){
        System.out.print(totalFruit(new int[]{1,2,1,3,3}));
    }
}