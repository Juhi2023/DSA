import java.util.*;

public class RemoveKDigits{
    
    public static String getSmallNumberByStack(String num , int k){
        int n = num.length();
        if(n==0 || n==k){
            return "0";
        }

        String ans="";
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            int d = num.charAt(i)-'0';
            while(!st.isEmpty() && d < st.peek() && k>0){
                st.pop();
                k--;
            }
            st.push(d);
        }

        while(k>0){
            st.pop();
            k--;
        }
        
        
        while(!st.isEmpty())
            ans=st.pop() + ans;

        //remove leading zeros
        int index=0;
        while(index < ans.length()-1 && ans.charAt(index)=='0')
            index++;

        return ans.substring(index);
    }

    public static void main(String[] args){
        System.out.println(getSmallNumberByStack("1432219", 1));
    }
}