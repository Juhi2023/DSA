import java.util.*;

class LongestStringChain {
    //Alternate tabulation approch as used in Print LIS
    //Time Complexity: O(N*N)
    //Space Complexity: O(N)
    public static boolean compareString(String prev, String next){
        int p=prev.length();
        int n = next.length();
        if(p+1!=n){
            return false;
        }
        int i=0;
        int j=0;
        while(i<p && j<n){
            if(prev.charAt(i)==next.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i==p;
    }

    static int largestChain(String words[], int n) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int dp[]=new int[n];
        Arrays.fill(dp, 1);
        for(int i=0; i<n; i++){
            for(int prev=0; prev< i; prev++){
                if(compareString(words[prev], words[i]) && dp[i]<1+dp[prev]){
                    dp[i]=1+dp[prev];
                }
            }
        }
        int ans=-1;
        for(int i=0; i<n; i++){
            ans=Math.max(ans, dp[i]);
        }
        return ans;
    }
    public static void main(String args[]) {
        String arr[] = {"a","b","ba","bca","bda","bdca"};
        int n = arr.length;
        System.out.println("The length of the longest chain " + largestChain(arr, n));
    }
}