import java.util.*;

class MinimumWindowSubstring{
    //Brute force
    //Time Complexity: O(n^2)
    //Space COmplexity: O(256)
    public static String findMinSubstring(String s, String t){
        int n =  s.length();
        int m = t.length();
        int index=0;
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int cnt=0;
            int freq[] = new int[256];
            for(int x: t.toCharArray()){
                freq[x]++;
            }
            for(int j=i; j<n; j++){
                if(freq[s.charAt(j)]>0){
                    cnt++;
                }
                freq[s.charAt(j)]--;
                if(cnt==m){
                    if(j-i+1 <minLen){
                        index=i;
                        minLen = j-i+1;
                    }
                }
            }
        }

        return s.substring(index, index+minLen);

    }

    //Sliding Window
    //Time Complexity: O(2n)
    //Space COmplexity: O(256)
    public static String findMinSubstringBySW(String s, String t){
        int n =  s.length();
        int m = t.length();
        int l=0;
        int r=0;
        int index=-1;
        int minLen = Integer.MAX_VALUE;
        
        int cnt=0;
        int freq[] = new int[256];
        for(int x: t.toCharArray()){
            freq[x]++;
        }

        while(r<n){
            if(freq[s.charAt(r)]>0){
                cnt++;
            }
            freq[s.charAt(r)]--;

            while(cnt==m){
                if(r-l+1 <minLen){
                    index=l;
                    minLen = r-l+1;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)]>0){
                    cnt--;
                }
                l++;
            }

            r++;
        }
        
        return index==-1? "": s.substring(index, index+minLen);

    }

    public static void main(String args[]){
        System.out.println(findMinSubstringBySW("ADOBECODEBANC", "ABC"));
    }
}