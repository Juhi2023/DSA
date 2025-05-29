import java.util.*;

class WordBreak2{

     public static boolean dictContain(String s, List<String> dict) {
        
        for (int i = 0; i < dict.size(); i++) {
            if (s.equals(dict.get(i)))
                return true;
        }
        return false;
    }

    //Brute Force
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    public static List<String> wordBreak(String s, List<String> dict) {
        StringBuilder str = new StringBuilder(s);
        List<String> ans = new ArrayList<>();
        helper(0, str, new StringBuilder(), ans, dict);
        return ans;
    }

    public static void helper(int start, StringBuilder s, StringBuilder temp, List<String> ans, List<String> dict){
        int n = s.length();
        if(start == n){
            ans.add(temp.toString().trim());
            return;
        }

        for(int k=start; k<n; k++){
            if(dict.contains(s.substring(start, k+1))){
                int currLen = temp.length();
                temp.append(" ");
                temp.append(s.substring(start, k+1));
                helper(k+1, s, temp, ans, dict);
                temp.setLength(currLen);
            }
        }
        return;
    }




    //DP: Memoization
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static List<String> wordBreakByMemo(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> memo = new HashMap<>();
        return dfs(s,memo, dict, 0);
    }

    public static List<String> dfs(String s, HashMap<Integer, List<String>> memo, HashSet<String> dict, int start) {
        if(memo.containsKey(start))
            return memo.get(start);
        
        List<String> result= new ArrayList<>();
        if(s.length()==start){
            result.add("");
            return result;
        }

        for(int i=start+1; i<=s.length(); i++){
            String word = s.substring(start, i);
            if(dict.contains(word)){
                List<String> sub = dfs(s, memo, dict, i);
                for(String x: sub){
                    result.add(word + (x.isEmpty() ? "": " ")+x);
                }
            }
        }
        memo.put(start, result);
        return result;
    }

    public static void main(String[] args) {
        String dict[] = {"apple","pen",};
        System.out.println(wordBreakByMemo("applepenapple", Arrays.asList(dict)));
    }
}