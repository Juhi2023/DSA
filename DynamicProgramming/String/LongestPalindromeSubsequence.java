import java.util.*;

public class LongestPalindromeSubsequence{

    //SO
    //Time Complexity: O(N*M)
    //Space Complexity: O((N)
    static int LPSSO(String s) {
        int n = s.length();
        String s2=  new StringBuilder(s).reverse().toString();;
        int prev[] = new int [n+1];

        for(int i=1; i<=n; i++){
            int temp[] = new int[n+1];
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    temp[j]= 1 + prev[j-1];
                }else{
                    temp[j] = Math.max(prev[j], temp[j-1]);
                }
            }
            prev=temp;
        }
        return prev[n];
    }


    public static void main(String[] args) {
        String s1 = "aabacdea";
        int lps = LPSSO(s1);
        System.out.println("Longest Palindrome Subsequence: " + lps);
    }
}
