import java.util.*;
class LongestRepeatingCharacterReplacement {
    
    //Brute Force
    //Time Complexity: O(N^3)
    //Space Complexity: O(1)
    public static int longestBrute(String s, int k) {
        int maxlen = 1;
        int n = s.length();

        for (int l = 0; l < n; ++l) {
            for (int r = l; r < n; ++r) {
                HashMap<Character, Integer> m = new HashMap<>();
                int f = 1;

                for (int i = l; i <= r; ++i){
                    m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
                    f = Math.max(f,  m.get(s.charAt(i)));
                }

                if (r - l + 1 - f <= k)
                    maxlen = Math.max(maxlen, r - l + 1);
            }
        }

        return maxlen;
    }

    //Optimized
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int longest(String s, int k) {
        
        int r=0;
        int l=0;
        int n=s.length();
        int maxLen=0;
        int ans=0;
        int hash[] = new int[26];
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxLen = Math.max(maxLen, hash[s.charAt(r)-'A']);
           while((r - l + 1) - maxLen > k) {
                hash[s.charAt(l) - 'A']--;
                maxLen=0;
                for(int i=0; i<26; i++)
                    maxLen = Math.max(maxLen, hash[i]);
                l++;
            }
            if (r - l + 1 - maxLen <= k)
                ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public static void main(String [] arg){
        System.out.print(longest("AABABBA", 2));
    }
}