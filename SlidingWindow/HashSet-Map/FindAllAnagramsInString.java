import java.util.*;

class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int n= s.length();
        int m = p.length();

        if(n<m){
            return ans;
        }

        int freqs[] = new int[26];
        int freqp[] = new int[26];
        for(int i=0; i<m; i++){
            freqs[s.charAt(i)-'a']++;
            freqp[p.charAt(i)-'a']++;
        }

        int l=0;
        int r=m;
        if(Arrays.equals(freqs, freqp)){
            ans.add(0);
        }

        while(r<n){
            freqs[s.charAt(l++)-'a']--;
            freqs[s.charAt(r++)-'a']++;

            if(Arrays.equals(freqs, freqp)){
                ans.add(l);
            }
        }
        return ans;
    }

    public static void main(String args[]){
        System.out.println(findAnagrams("acbsdhgkvmmcda", "abc"));
    }
}