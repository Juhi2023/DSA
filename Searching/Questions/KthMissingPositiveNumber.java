class KthMissingPositiveNumber{
    //Using Brute
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int getKthMissingNumber(int nums[], int k){
        int n= nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]<=k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }

    //Using Binary Search
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int getKthMissingNumberByBS(int nums[], int k){
        int n= nums.length;
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            int missing = nums[mid] - (mid+1); //11-5 = 6;
            if(missing<k){
                low= mid+1;
            }else{
                high = mid-1;
            }
        }

        //the number of missing numbers = arr[high] - (high+1).
        //remaining missing number = k- (arr[high] - (high+1))
        //get kth missing number = arr[high] + (k- (arr[high] - (high+1))) = k + high + 1;

        return k+high+1;
    }

    public static void main(String args[]){
        System.out.println(getKthMissingNumberByBS(new int[]{2,3,4,7,11}, 5));
    }
}
