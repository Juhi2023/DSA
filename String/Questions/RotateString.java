//https://leetcode.com/problems/rotate-string/description/

import java.util.* ;
class RotateString{

    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
    public boolean rotateStringBruteForce(String s, String goal) {
        int i=0;
        String newStr="";

        while(i<s.length()){
            if(goal.equals(s.substring(i)+newStr))
                return true;
            newStr+= s.charAt(i);
            i++;
        }
        return false;
    }

    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){ 
            return false;
        }
        String doubledS=s+s;
        return doubledS.contains(goal);
    }

    public static void main(String [] arg){
        System.out.print(rotateString("abcde", "cdeab"));
    }
}