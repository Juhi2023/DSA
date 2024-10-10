//https://leetcode.com/problems/3sum/description/

import java.util.* ;
class ThreeSum{
    //Brute Force
    //Time Complaxity: O(N^3) + O(N * logN)
    //Space Complexity: O(2 * No of triplets)
    public static List<List<Integer>> getTripletsByBruteForce(int nums []){
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    //Better Force
    //Time Complaxity: O(N^2) + O(N logN)
    //Space Complexity: O(2 * no of triplets)
    public static List<List<Integer>> getTripletsByBetterAppraoch(int nums []){
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0; i<n; i++){
            HashSet<Integer> s = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int rem = 0 - nums[i] - nums[j];
                if(s.contains(rem)){
                    set.add(Arrays.asList(nums[i], nums[j], rem));
                }
                s.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }

    //Two Pointer
    //Time Complaxity: O(N^2) + O(N logN)
    //Space Complexity: O(1)
    public static List<List<Integer>> getTripletsByOptimisedAppraoch(int nums []){
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            //remove duplicates:
            if (i != 0 && nums[i] == nums[i - 1]) 
                continue;

            int j=i+1;
            int k=n-1;
            while(j<k){
                long sum = nums[i]+nums[j]+nums[k];

                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                }

            }

        }

        return ans;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {-1,0,1,2,-1,-4,-2,-3,3,0,4};

        System.out.println(getTripletsByBruteForce(arr));
        System.out.println(getTripletsByBetterAppraoch(arr));
        System.out.println(getTripletsByOptimisedAppraoch(arr));
    }
}