import java.util.*;
class LongestSubstringWithAtMostKDistinctCharacters {


    //Optimized
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int longest(String s, int k) {
        int r=0;
        int l=0;
        int ans=-1;
        int n= s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
                while(map.size()>k){
                    char curr = s.charAt(l);
                    map.put(curr, map.get(curr)-1);
                    map.remove(curr, 0);
                    l++;
                }
        
            if(map.size()==k){
                
                ans = Math.max(ans, r-l+1);
            }
            r++;
            
        }
        return ans;
    }

    public static void main(String [] arg){
        System.out.print(longest("abbbbbbc", 2));
    }
}