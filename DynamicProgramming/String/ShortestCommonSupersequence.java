import java.util.*;

public class ShortestCommonSupersequence{
    //Tabulation
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static String shortestCS(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        int t[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                t[i][j]=0;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){`
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        int i=m,j=n;
        StringBuilder scs=new StringBuilder();
        while(i>0&&j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                scs.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(t[i][j-1]>t[i-1][j]){
                scs.append(str2.charAt(j-1));
                j--;
            }else{
                scs.append(str1.charAt(i-1));
                i--;
            }
        }
        while(i>0){
            scs.append(str1.charAt(i-1));
            i--;

        }
        while(j>0){
            scs.append(str2.charAt(j-1));
            j--;
        }
        return scs.reverse().toString();
    }


    public static void main(String[] args) {
        String s1 = "sea";
        String s2= "eat";
        String scs = shortestCS(s1, s2);
        System.out.println(scs);
    }
}
