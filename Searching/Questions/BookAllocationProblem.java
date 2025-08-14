class BookAllocationProblem {
    public static boolean canAssign(int[] arr, int students, int x){
        int total=0;
        int ans=1;
        for(int i=0; i< arr.length; i++){
            if(arr[i]+total<=x){
                total+= arr[i];
            }else{
                ans++;
                total=arr[i];
            }
        }
        return ans<=students;
    }

    //Using Brute
    //Time Complexity: O(n*(SUM(arr)- MAX(arr[])))
    //Space Complexity: O(1)
    public static int allocateBook(int[] arr, int students) {
        int n=arr.length;
        if(n<students){
            return -1;
        }        int high = 0;
        int low = 0;

        for(int i=0; i<n; i++){
            high+= arr[i];
            low=Math.max(low, arr[i]);
        }

        for(int i=low; i<=high; i++){
            if(canAssign(arr,students, i)){
                return i;
            }
        }
        return -1;
    }

    //Using Binary Search
    //Time Complexity: O(n* log(SUM(arr[])- MAX(arr[])))
    //Space Complexity: O(1)
    public static int allocateBookByBS(int[] arr, int students) {
        int n=arr.length;
        if(n<students){
            return -1;
        }
        int high = 0;
        int low = 0;

        for(int i=0; i<n; i++){
            high+=arr[i];
            low=Math.max(low, arr[i]);
        }

        while(low<=high){
            int mid = low + (high - low) / 2;
            if(canAssign(arr, students, mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public static void main(String args[]){
        System.out.println(allocateBook(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
    }

}