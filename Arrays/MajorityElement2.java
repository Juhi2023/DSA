//https://leetcode.com/problems/majority-element-ii/description/

import java.util.* ;
class MajorityElement2{
    
    //Moore voting algorithm
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static List<Integer> majorityElementByMoreVotingAlgo(int nums []){
        int n= nums.length;
        int count1=0, count2=0;
        int ele1=Integer.MIN_VALUE, ele2=Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(count1==0 && ele2 != nums[i]){
                ele1=nums[i];
                count1++;
            }else if(count2==0 && ele1 != nums[i]){
                ele2=nums[i];
                count2++;
            }else if(ele1 == nums[i]){
                count1++;
            }else if(ele2 == nums[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;

        for(int i=0; i<n; i++){
            if(nums[i]==ele1)
                count1++;
            else if(nums[i]==ele2)
                count2++;
        }
        int mini = (int)(n / 3) + 1;
        if (count1 >= mini) ans.add(ele1);
        if (count2 >= mini) ans.add(ele2);
        return ans;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {3,2,2,2,3,3};

        List<Integer> ans = majorityElementByMoreVotingAlgo(arr);

        for(int n : ans)
            System.out.print(n+" ");
    }
}