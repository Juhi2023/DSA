import java.util.*;
class SecondLargestElement {

    //Time Complexity : O(n * log n)
    public static int findByBruteForce(int nums[]){
        Arrays.sort(nums);
        int n=nums.length;
        int largest = nums[n-1];
        int secondLargest = -1;
        int i=n-1;
        while(i>0){
            if(nums[i] != nums[i-1]){
                secondLargest=nums[i-1];
                break;
            }
            i--;
        }
        return secondLargest;
    }

    //Time Complexity : O(n)
    public static int findByOnePass(int nums[]){
        int n=nums.length;

        if(n<2)
            return -1;
        int largest = nums[0];
        int secondLargest = Integer.MIN_VALUE;
        int i=0;
        while(i<n){
            if(nums[i]>largest){
                secondLargest=largest;
                largest=nums[i];
            }else if(nums[i]>secondLargest && nums[i] != largest){
                secondLargest=nums[i];
            }
            i++;
        }
        return secondLargest;
    }

    public static void main(String args[]){
        int arr[] = {2,3,4,2,9,9,9,5,5,2,1};
        System.out.println(findByOnePass(arr));
    }
}