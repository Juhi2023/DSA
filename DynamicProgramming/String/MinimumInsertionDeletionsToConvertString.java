import java.util.*;

public class MinimumInsertionDeletionsToConvertString{
    //SO
    //Time Complexity: O(N*M)
    //Space Complexity: O((N)
    static int minInsertionDeletionSO(String word1, String word2) {
        int n = word1.length();
        int m= word2.length();
        int prev[] = new int [m+1];

        for(int i=1; i<=n; i++){
            int temp[] = new int[m+1];
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    temp[j]= 1 + prev[j-1];
                }else{
                    temp[j] = Math.max(prev[j], temp[j-1]);
                }
            }
            prev=temp;
        }
        return n-prev[m]+m-prev[m];
    }


    public static void main(String[] args) {
        String s1 = "sea";
        String s2= "eat";
        int lps = minInsertionDeletionSO(s1, s2);
        System.out.println(lps);
    }
}
