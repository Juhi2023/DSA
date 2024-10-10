//https://leetcode.com/problems/4sum/description/

import java.util.* ;
class FourSum{
    //Brute Force
    //Time Complaxity: O(N^4) + O(N * logN)
    //Space Complexity: O(2 * No of quadruplets)
    public static List<List<Integer>> getQuadrupletsByBruteForce(int nums [], int target){
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                        for(int l=k+1; l<n; l++){
                            if(nums[i]+nums[j]+nums[k]+nums[l]==0){
                            set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    //Better Force
    //Time Complaxity: O(N^2) + O(N logN)
    //Space Complexity: O(2 * No of quadruplets)
    public static List<List<Integer>> getQuadrupletsByBetterAppraoch(int nums [], int target){
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                HashSet<Integer> s = new HashSet<>();
                for(int k=j+1; k<n; k++){
                    int rem = 0 - nums[i] - nums[j] - nums[k];
                    if(s.contains(rem)){
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], rem));
                    }
                    s.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(set);
    }

    //Two Pointer
    //Time Complaxity: O(N^3) + O(N logN)
    //Space Complexity: O(1)
    public static List<List<Integer>> getQuadrupletsByOptimisedAppraoch(int nums [], int target){
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            //remove duplicates:
            if (i != 0 && nums[i] == nums[i - 1]) 
                continue;
            
            for(int j=i+1; j<n; j++){
                if (j >i+1 && nums[j] == nums[j - 1]) 
                    continue;

                int start=j+1;
                int end=n-1;
                while(start<end){
                    long sum = (long)nums[i]+nums[j]+nums[start]+nums[end];

                    if(sum>target){
                        end--;
                    }else if(sum<target){
                        start++;
                    }else{
                        ans.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                        while(start<end && nums[start]==nums[start-1]){
                            start++;
                        }
                        while(start<end  && nums[end]==nums[end+1]){
                            end--;
                        }
                    }

                }
            }
        }

        return ans;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {1,0,-1,0,-2,2};

        System.out.println(getQuadrupletsByBruteForce(arr, 0));
        System.out.println(getQuadrupletsByBetterAppraoch(arr, 0));
        System.out.println(getQuadrupletsByOptimisedAppraoch(arr, 0));
    }
}