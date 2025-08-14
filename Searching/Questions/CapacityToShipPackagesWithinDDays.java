class CapacityToShipPackagesWithinDDays {
    public static boolean canShip(int[] weights, int days, int x){
        int total=0;
        int ans=1;
        for(int i=0; i< weights.length; i++){
            if(weights[i]+total<=x){
                total+= weights[i];
            }else{
                ans++;
                total=weights[i];
            }
        }
        return ans<=days;
    }

    //Using Brute
    //Time Complexity: O(n*(SUM(Weights)- MAX(weight[])))
    //Space Complexity: O(1)
    public static int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int high = 0;
        int low = 0;

        for(int i=0; i<n; i++){
            high+= weights[i];
            low=Math.max(low, weights[i]);
        }

        for(int i=low; i<=high; i++){
            if(canShip(weights,days, i)){
                return i;
            }
        }
        return -1;
    }

    //Using Binary Search
    //Time Complexity: O(n* log(SUM(Weights[])- MAX(weight[])))
    //Space Complexity: O(1)
    public static int shipWithinDaysByBS(int[] weights, int days) {
        int n=weights.length;

        int high = 0;
        int low = 0;

        for(int i=0; i<n; i++){
            high+=weights[i];
            low=Math.max(low, weights[i]);
        }

        while(low<=high){
            int mid = low + (high - low) / 2;
            if(canShip(weights, days, mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public static void main(String args[]){
        System.out.println(shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
    }

}