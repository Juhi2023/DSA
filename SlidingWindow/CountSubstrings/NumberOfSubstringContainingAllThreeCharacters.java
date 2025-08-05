import java.util.*;
class NumberOfSubstringContainingAllThreeCharacters {


    //Optimized
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    private static boolean hasAllChars(int[] freq) {
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }

    public static int numberOfSubstrings(String s) {
        int n = s.length();
        if(n<3)
            return 0;
        int freq[] = new int[3];
        freq[s.charAt(0)-'a']++;
        freq[s.charAt(1)-'a']++;
        int ans=0;
        int left=0;
        int right=2;
        while(right<n){
            freq[s.charAt(right)-'a']++;
            while(hasAllChars(freq)){
                ans+= n-right;
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
    public static void main(String [] arg){
        System.out.print(numberOfSubstrings("abcabc"));
    }
}