import java.util.*;

public class ValidAnagram{
    //Brute force
    //Time Complexity: O(n * logn)
    public static String SortString(String str){
        char c[] = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    public static boolean checkAnagrams(String str1, String str2){
        if (str1.length() != str2.length())
        return false;
    
        str1 = SortString(str1);
        str2 = SortString(str2);
    
        for (int i = 0; i < str1.length(); i++)
        {
        if (str1.charAt(i) != str2.charAt(i))
            return false;
        }
        return true;
    }


    //Time Complexity: O(n)
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int alpha[]= new int[26];
        for(int i=0 ;i <s.length(); i++){
            alpha[s.charAt(i)-'a']++;
        }

        for(int i=0 ;i <t.length(); i++){
            alpha[t.charAt(i)-'a']--;
        }

        for(int i=0 ;i <26; i++){
            if(alpha[i]!=0)
                return false;
        }

        return true;
    }

    public static void main (String args[]){
        System.out.println(isAnagram("eat", "ate"));
    }
}