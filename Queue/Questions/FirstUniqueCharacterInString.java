import java.util.*;
class FirstUniqueCharacterInString {

    public static int firstUniqChar(String s) {
        int freq[] = new int[26];
        Arrays.fill(freq, -1);

        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i)-'a';
            if(freq[c]==-1)
                freq[c]=i;
            else
                freq[c]=-2;
        }
        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i)-'a']>=0)
                return freq[s.charAt(i)-'a'];
        }
        return -1;
    }

    public static void main(String args[]){
        System.out.println(firstUniqChar("leetcode"));
    }
}