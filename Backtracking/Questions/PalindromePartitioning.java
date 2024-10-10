import java.io.*;
import java.lang.*;

class PalindromePartitioning{

    public static boolean isPalindromic(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    //Time Complexity: O(2^n * n/2)
    //Space Complexity: O(n)
    public static void getPalindromicPartions(String s, int index, List<List<String>> ans, List<String> partitions){
        if(index==s.length()){
            ans.add(new ArrayList<>(partitions));
            return;
        }
            
        for(int i= index ; i<s.length; i++){
            if(isPalindromic(s, index, i)){
                partitions.add(s.substring(index, i+1));
                getPalindromicPartions(s, index+1, ans, partitions);
                partitions.remove(partitions.size()-1);
            }            
        }
    }


    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        getPalindromicPartions("aabb", 0, ans, new ArrayList<>());
        System.out.println(ans);
    }
}