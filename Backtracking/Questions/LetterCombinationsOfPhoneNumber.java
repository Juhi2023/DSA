import java.util.*;
class LetterCombinationsOfPhoneNumber {
    
    //Time Complxity: O(4^ number of digits)
    //Space Comlexity: O(number of digits)
    static String[] keys={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public static void helper(List<String> ans, StringBuilder combination,  String digits, int index){
        if(combination.length()==digits.length()){
            ans.add(combination.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String key = keys[digit];

        for(int i=0; i< key.length(); i++){
            combination.append(key.charAt(i));
            helper(ans, combination, digits, index+1);
            combination.deleteCharAt(combination.length()-1);
        }

    }
    public static void main(String args[]) {
        String digits = "23";
        List<String> result = new ArrayList<String>();
        if(digits.length()>0)
            helper(result, new StringBuilder(), digits, 0);
        System.out.println(result);
    }
}