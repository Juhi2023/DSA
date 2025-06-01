import java.util.*;

public class LongestPalindromicString{

    //Memoization
    //Time Complexity: O(N*N)
    //Space Complexity: O((N*N)
    static String longest="";
    static boolean helper(String s, int i, int j, Boolean[][] dp) {
        if (i > j) 
            return true;

        if (dp[i][j] != null) 
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            if (j - i <= 2 || helper(s, i + 1, j - 1, dp)) {
                dp[i][j] = true;

                if (j - i + 1 > longest.length()) {
                    longest = s.substring(i, j + 1);
                }
                return true;
            }
        }
        helper(s, i + 1, j, dp);
        helper(s, i, j - 1, dp);
        return dp[i][j] = false;
    }

    static String LPSMemo(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n]; 
        helper(s, 0, n - 1, dp);
        return longest;
    }


    //Tabulation
    //Time Complexity: O(N*N)
    //Space Complexity: O((N*N)
    static String LPSTab(String s) {
        int n = s.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        String longest = s.substring(0, 1); // At least one character is a palindrome

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                longest = s.substring(i, i + 2);
            }
        }

        // Check substrings of length 3 or more
        for (int diff = 3; diff <= n; diff++) {
            for (int i = 0; i <= n - diff; i++) {
                int j = i + diff - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (diff > longest.length()) {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }

        return longest;
    }


    //SO
    //Time Complexity: O(N*N)
    //Space Complexity: O((N)
    

    public static void main(String[] args) {
        String s1 = "abacde";
        String lps = LPSTab(s1);
        System.out.println("Longest Palandrome Substring: " + lps);
    }
}
