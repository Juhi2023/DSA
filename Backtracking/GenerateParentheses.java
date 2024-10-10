import java.util.*;

public class GenerateParentheses{

    //Brute Force
    //Time Complexity: O(2^N) 
    //Space Complexity: O(2^n) [Storing Ans Space] + O(n)[Stack space]
    public static void helper(int n, int open, int close, StringBuilder str, List<String> ans){
        if(str.length()== 2*n){
            ans.add(str.toString());
            return;
        }

        if(open<n){
            str.append('(');
            helper(n, open+1, close, str, ans);
            str.deleteCharAt(str.length()-1);
        }

        if(close<open){
            str.append(')');
            helper(n, open, close+1, str, ans);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String [] arg){
        List<String> ans = new ArrayList<>();
        helper(3, 0, 0, new StringBuilder(), ans);
        System.out.println(ans);
    }
}