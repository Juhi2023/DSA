//https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/description/

class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder res = new StringBuilder();
        k -= n; 
        
        for (int i = n - 1; i >= 0; i--) {
            int add = Math.min(k, 25);
            res.append((char) ('a' + add));
            k -= add;
        }
        
        return res.reverse().toString(); 
    }
}