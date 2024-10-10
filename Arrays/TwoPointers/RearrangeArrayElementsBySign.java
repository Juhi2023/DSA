//https://leetcode.com/problems/two-sum/description/

import java.util.* ;
class RearrangeArrayElementsBySign{

    //Brute Force
    //Time Complxity: O(2 * N)
    //Optimized: O(N/2) + O(N/2)
    public static int[] rearrangeArrayByBruteForce(int nums []){
        int n= nums.length;
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        for(int i=0; i<n; i++){
            if(nums[i]<0){
                neg.add(nums[i]);
            }else{
                pos.add(nums[i]);
            }
        }
        for(int i=0; i<n/2; i++){
            nums[2*i] = pos.get(i);
            nums[2*i +1] = neg.get(i);
        }
        return nums;
    }

    //Optimized 
    //Time Complxity: O(N)
    //Optimized: O(N)
    public static int[] rearrangeArrayOptimized(int nums []){
        int n=nums.length;
        int result [] =new int[n];
        int posIndex=0;
        int negIndex=1;

        for(int i=0; i<n; i++){
            if(nums[i]<0){
                result[negIndex]=nums[i];
                negIndex+=2;
            }else{
                result[posIndex]=nums[i];
                posIndex+=2;
            }
        }
        return result;
    }

    //VAriation in question
    //There’s an array ‘A’ of size ‘N’ with positive and negative elements (not necessarily equal). Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values. The leftover elements should be placed at the very end in the same order as in array A.
    public static int[] rearrangeArrayWithVariation(int nums []){
        int n= nums.length;
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        for(int i=0; i<n; i++){
            if(nums[i]<0){
                neg.add(nums[i]);
            }else{
                pos.add(nums[i]);
            }
        }
        int size = Math.min(pos.size(), neg.size());
        for(int i=0; i<size; i++){
            nums[2*i] = pos.get(i);
            nums[2*i +1] = neg.get(i);
        }


        int j=size;
        size*=2;
        while(size<n){
            nums[size]=pos.size() > neg.size() ? pos.get(j): neg.get(j);
            size++;
            j++;
        }

        return nums;
    }


    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {3,-1,-2,-5,2,-4};

        int ans[] = rearrangeArrayWithVariation(arr);
        for(int n: ans){
            System.out.print(n+" ");
        }
    }
}