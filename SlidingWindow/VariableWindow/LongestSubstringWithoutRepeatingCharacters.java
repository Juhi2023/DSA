//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.* ;
class LongestSubstringWithoutRepeatingCharacters{

    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
    public static int getLengthByBruteForce(String str) {

        if(str.length()==0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) 
        {
            Set < Character > se = new HashSet < > ();
            for (int j = i; j < str.length(); j++){
                if (se.contains(str.charAt(j))) {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(str.charAt(j));
            }
        }
        return maxans;
    }

    //Time Complexity: O(2N)
    //Space Complexity: O(1) //26
    public static int getLengthBySlidingWindow(String s) {
        if(s.length()==0)
            return 0;

        int maxLength =0;
        int l=0;
        Set<Character> visited = new HashSet<>();

        for(int r=0; r< s.length(); r++){
            if(visited.contains(s.charAt(r))){
                while(l<r && visited.contains(s.charAt(r))){
                    visited.remove(s.charAt(l));
                    l++;
                }
            }
            visited.add(s.charAt(r));
            maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength;
    }

    public static int getLengthBySlidingWindowWithVisitedArray(String s) {
        if (s.length() == 0)
            return 0;

        if (s.length() == 1)
            return 1;

        int maxLength = 0;
        boolean[] visited = new boolean[256];

        int left = 0, right = 0;
        while (right < s.length()) {
            while (visited[s.charAt(right)]) {
                visited[s.charAt(left)] = false;
                left++;
            }

            visited[s.charAt(right)] = true;
            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }
        return maxLength;
    }

    


    public static void main(String [] arg){
        System.out.print(getLengthBySlidingWindow("abcabcbb"));
    }
}