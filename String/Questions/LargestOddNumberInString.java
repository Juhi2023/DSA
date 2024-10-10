//https://leetcode.com/problems/largest-odd-number-in-string/description/

import java.util.* ;
class LargestOddNumberInString{
    public static String largestOddNumber(String num) {
        int i=num.length()-1;
        while(i>=0){
            if((num.charAt(i)-'0')%2==1)
                return num.substring(0,i+1);
            i--;
        }
        return "";
    }

    public static void main(String [] arg){
        System.out.print(largestOddNumber("434673"));
    }
}