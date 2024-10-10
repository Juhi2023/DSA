import java.util.*;
class PrintLargestWordAndItsIndex{

    public static void getLargestWord(String s){
        int n = s.length();
        int i=0;
        int max=0;
        int start=0, end=0;
        int currLength =0;

        while(i<=n){
            if(i==n || s.charAt(i)==' '){
                if(max < currLength){
                    max = currLength;
                    end = i-1;
                    start = i-currLength;
                }
                currLength=0;
            }else{
                currLength++;
            }
            i++;
        }

        System.out.println("Max Length: "+max);
        System.out.println("Start Index: "+ start);
        System.out.println("End Index: "+ end);
    }

    public static void main(String [] args){
        getLargestWord("toooo to HAVEEEEE");
    }
}