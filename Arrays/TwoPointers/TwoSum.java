//https://leetcode.com/problems/two-sum/description/

import java.util.* ;
class TwoSum{
    public static void getTwoElement(int nums [], int target){
        int re[]={0,0};
        HashMap<Integer, Integer> ob= new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(ob.containsKey(target-nums[i])){
                re[0]=i;
                re[1]=ob.get(target-nums[i]);
                break;
            }
            
            ob.put(nums[i], i);
        }

        System.out.println("["+re[0]+", "+re[1]+"]");
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {1,2,2,2,3,3};

        getTwoElement(arr, 5);
    }
}