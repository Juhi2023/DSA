import java.io.*;
import java.lang.*;

class WordBreak{

    public static boolean dictContain(String s, List<String> dict){
        for(int i=0; i< dict.size(); i++){
            if(s.equals(dict.get(i)))
                return true;
        }
        return false;
    }

    //Time Complexity: O(2^n)
    //Space Complexity: O(n)
    public static boolean checkWords(String s, List<String> dict){
        if(s.isEmpty()){
            return true;
        }
            
        for(int i= 0 ; i<s.length(); i++){
            String newStr = s.substring(0, i+1);
            if(dictContain(newStr, dict)){
                if(checkWords(newStr, dict))
                    return true;
            }            
        }

        return false;
    }


    public static void main(String[] args) {
        String dict[] = {"apple","pen"};
        System.out.println(checkWords("applepenapple", dict));
    }
}