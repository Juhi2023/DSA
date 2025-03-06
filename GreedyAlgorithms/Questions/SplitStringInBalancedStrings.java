import java.util.*;
class SplitStringInBalancedStrings{

    public static int split(String s){
        int n=s.length();
        int r=0, l=0, cnt=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='R')
                r++;
            else
                l++;
            if(r==l){
                cnt++;
                r=0;
                l=0;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(split("RLRRLLRLRL"));
    }
}