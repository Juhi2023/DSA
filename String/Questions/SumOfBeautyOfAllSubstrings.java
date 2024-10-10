//https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

import java.util.* ;
class SumOfBeautyOfAllSubstrings{

    //Time Complexity: O(N^2 * 26)
    //Space Complexity: O(1)
    public static boolean beautySum(String s) {
        int sum=0;
        for(int i=0; i<s.length();i++){
            int feq[] = new int[26];
            for(int j=i; j<s.length(); j++){
                int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
                feq[s.charAt(j)-'a']++;
                for(int k=0; k<26; k++){
                    if(feq[k]>0){
                        min = Math.min(min, feq[k]);
                        max = Math.max(max, feq[k]);
                    }
                }
                sum+= max-min;
            }
        }
        return sum;
    }


    public static void main(String [] arg){
        System.out.print(beautySum("aabcb"));
    }
}