//https://leetcode.com/problems/longest-consecutive-sequence/description/
import java.util.*;

public class LongestConsecutiveSequence{

    //Brute Force
    //Time Complexity: O(N^2)
    //Space Comlexity: O(1)
    public static boolean linearSearch(int nums[], int target){
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
    }

    public static int longestConsecutiveByBruteForce(int nums[]){
        int n = nums.length;
        int maxLength=0;

        for(int i=0; i<n; i++){
            int num=nums[i];
            int count=1;

            while(linearSearch(nums, num+1)==true){
                count++;
                num++;
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }

    //Sorting
    //Time Complexity: O(N * logN) + O(N) 
    //Space Comlexity: O(1)
    public static int longestConsecutiveBySorting(int nums[]){
        Arrays.sort(nums);
        int n = nums.length;
        if(n==0)
            return 0;

        int maxLength=1;
        int count=1;
        int lastElement = nums[0];

        for(int i=1; i<n; i++){
            if(nums[i]== (lastElement + 1)){
                count++;
            }else{
                count=1;
            }
            maxLength = Math.max(maxLength, count);
            lastElement= nums[i];
        }
        return maxLength;
    }

    //HashSet
    //find staring point of each consecutive numbers
    //Time Complexity: O(N) + O(2N)
    //Space Comlexity: O(N)
    public static int longestConsecutiveByHashSet(int nums[]){
        int n = nums.length;
        if(n==0)
            return 0;

        int maxLength=1;
        int count=1;
        HashSet<Integer> set =  new HashSet<>();
        
        for(int x : nums){
            set.add(x);
        }

        for(int x : nums){
            if(set.contains(x-1)){
                continue;
            }else{
                while(set.contains(x+1)){
                    count++;
                    x++;
                }
                maxLength = Math.max(count, maxLength);
                count=1;
            }
        }
        
        return maxLength;
    }

    public static void main(String [] arg){
        int nums[]={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveByHashSet(nums));
    }
}