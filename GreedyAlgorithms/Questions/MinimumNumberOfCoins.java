//https://www.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1

import java.util.*;
class MinimumNumberOfCoins{

    public static int getNumberOfCoins(int[] coins, int n) {
        int ans=0;
        int i=coins.length-1;
        while(i>=0 && n>0){
            if(coins[i]<=n){
                n=n-coins[i];
                ans++;
            }else{
                i--;
            }
        }
        if(n>0)
            return -1;
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        System.out.println(getNumberOfCoins(coins, 70));
    }
}