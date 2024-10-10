// /https://leetcode.com/problems/string-to-integer-atoi/description/

public class StringToInteger{

    //using loop
    public static int getInteger1(String s){
        int index=0;
        int sign=1;
        int n= s.length();
        
        while(index<n && s.charAt(index)==' '){
            index++;
        }

        if(index>n)
            return 0;

        if(s.charAt(index)=='-'){
            index++;
            sign=-1;
        }else if(s.charAt(index)=='+'){
            index++;
        }

        long result = 0;
        while(index<n){
            if(s.charAt(index)>='0' && s.charAt(index)<='9'){
                result = result*10 +(s.charAt(index)-'0');
                if(result>Integer.MAX_VALUE)
                    return sign==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                index++;
            } 
            else 
                break;
        }
        return (int)(result*sign);
    }

    //using recursion
    public static int getNumber(String s, int index, int result){
        if(index>s.length())
            return 0;
        if(s.charAt(index)>='0' && s.charAt(index)<='9')
            return getNumber(s, index+1, result*10 + (s.charAt(index)-'0'));

        return result;
    }
    public static int getInteger2(String s){
        int index=0;
        int sign=1;
        int n= s.length();
        
        while(index<n && s.charAt(index)==' '){
            index++;
        }

        if(index>n)
            return 0;

        if(s.charAt(index)=='-'){
            index++;
            sign=-1;
        }else if(s.charAt(index)=='+'){
            index++;
        }

        return sign * getNumber(s, index, 0);
    }

    public static void main(String [] args){
        System.out.println(getInteger1("    -454bfbfb9999"));
        System.out.println(getInteger2("    -454bfbfb9999"));
    }
}