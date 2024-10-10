import java.util.*;

public class ValidPalindrome{

    public static boolean isValid(char c){
        if((c>='A' && c<='Z') || (c>='a' && c<='z')){
            return true;
        }
        return false;
    }
    
    public static boolean isPalindrome(String s) {
        if(s.length()==0)
            return true;

        int start=0, end=s.length()-1;

        while(start<=end){
            if(!isValid(s.charAt(start))){
                start++;
            }else if(!isValid(s.charAt(end))){
                end--;
            }else if(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main (String args[]){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}