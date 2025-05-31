import java.util.*;

class WordBreak{

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
    public static boolean checkWords(String s, List<String> dict) {
        if (s.isEmpty()) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            String newStr = s.substring(0, i + 1);
            if (dictContain(newStr, dict) && checkWords(s.substring(i + 1), dict)) {
                    return true;
            }
        }
        return false;
    }

    // other way can apply memoization also
    // public static boolean checkWords(String s, List<String> dict, int i) {
    //     if (i>=s.length()) {
    //         return true;
    //     }

    //     for(String word: dict){
    //         int  size =  word.length();
    //         if(i+size-1 >= s.length()){
    //             continue;
    //         }
    //         if(word.equals(s.substring(i, i+size)) && checkWords(s, dict, i+size)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }





    //DP: Memoization
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    private static boolean helperM(int start, String s, Set<String> wordSet, Boolean[] memo) {
        if (start == s.length()) return true; 
        if (memo[start] != null) return memo[start]; 

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) && helperM(end, s, wordSet, memo)) {
                return memo[start] = true; 
            }
        }
        return memo[start] = false;
    }

    public static boolean checkWordsByDPMemoization(String s, List<String> dict){
        Set<String> wordSet = new HashSet<>(dict);
        Boolean[] memo = new Boolean[s.length()];
        
        return helperM(0, s, wordSet, memo);
    }

    //DP: Tabulation
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static boolean checkWordsByDPTabulation(String s, List<String> dict){
        Boolean[] memo = new Boolean[s.length()+1];
        memo[0] = true;
        for(int i=1; i<=s.length(); i++){
            //memo[j] check whether previous words are breakable
            for(int j=0; j< i; j++){
                if(memo[j] && dictContain(s.substring(j, i), dict)){
                    memo[i]=true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }

    public static void main(String[] args) {
        String dict[] = {"apple","pen"};
        System.out.println(checkWords("applepenapple", Arrays.asList(dict)));
    }
}