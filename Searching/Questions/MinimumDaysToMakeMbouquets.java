class MinimumDaysToMakeMbouquets {
    public static boolean canBloomInXDays(int[] bloomDay, int m, int k, int day){
        int cnt=0;
        int ans=0;
        for(int i=0; i< bloomDay.length; i++){
            if(bloomDay[i]<=day){
                cnt++;
            }else{
                ans+= cnt/k;
                cnt=0;
            }
        }
        ans+=cnt/k;
        return ans>=m;
    }

    //Using Brute
    //Time Complexity: O(n*(high-low))
    //Space Complexity: O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k >n){
            return -1;
        }

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            high=Math.max(high, bloomDay[i]);
            low=Math.min(low, bloomDay[i]);
        }

        for(int i=low; i<=high; i++){
            if(canBloomInXDays(bloomDay, m, k, i)){
                return i;
            }
        }
        return -1;
    }

    //Using Binary Search
    //Time Complexity: O(n* log(high-low))
    //Space Complexity: O(1)
    public static int minDaysByBS(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k >n){
            return -1;
        }

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;


        for(int i=0; i<n; i++){
            high=Math.max(high, bloomDay[i]);
            low=Math.min(low, bloomDay[i]);
        }

        while(low<=high){
            int mid = low + (high - low) / 2;
            if(canBloomInXDays(bloomDay, m, k, mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public static void main(String args[]){
        System.out.println(minDaysByBS(new int[] {7, 7, 7, 7, 13, 11, 12, 7}, 2, 3));
    }

}