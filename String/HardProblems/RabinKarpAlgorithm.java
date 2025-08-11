import java.util.*;

class RabinKarpAlgorithm{
    public final static int PRIME=101;

    //Rolling funtion
    public static double calculateHash(String str){
        double hash=0;
        for(int i=0; i<str.length(); i++){
            hash = hash + str.charAt(i)*Math.pow(PRIME, i);
        }
        return hash;
    }

    //polynomial hashing
    public static boolean findSubstring(String text, String pattern){
        int n=text.length();
        int m=pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, m));

        for(int i=0; i<= n-m; i++){
            if(textHash==patternHash){
                if(text.substring(i, i+m).equals(pattern)){
                    return true;
                }
            }

            //update text hash
            if(i<n-m){
                int oldChar = text.charAt(i);
                double hashOfOldChar = oldChar; // * Math.pow(PRIME, 0) ==1
                int newChar = text.charAt(i+m);
                double hashOfNewChar = newChar * Math.pow(PRIME, m-1);

                //removed old char hash
                textHash =  (textHash - oldChar)/PRIME;
                //added new char hash
                textHash += hashOfNewChar ;
            }
        }
        return false;

    }

    //rabin karp
    private static final int BASE = 256;               // alphabet size
    private static final long MOD = 1_000_000_007L;    // large prime

    public static int rabinKarpAlgo(String text, String pattern) {
        if (pattern == null || text == null) return -1;
        int n = text.length();
        int m = pattern.length();
        if (m > n) 
            return -1;

        long patternHash = 0;
        long windowHash = 0;
        long power = 1;

        // Precompute BASE^(m-1) % MOD
        for (int i = 0; i < m - 1; i++) {
            power = (power * BASE) % MOD;
        }

        // Initial hash values for pattern and first window
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
            windowHash = (windowHash * BASE + text.charAt(i)) % MOD;
        }

        // Slide over text
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == windowHash) {
                int j=0;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) 
                        break;
                }

                if (j == m) 
                    return i;
            }

            // Roll the hash to the next window
            if (i < n - m) {
                long leading = (text.charAt(i) * power) % MOD;
                windowHash = (windowHash - leading + MOD) % MOD; // remove leading char
                windowHash = (windowHash * BASE + text.charAt(i + m)) % MOD; // add new char
            }
        }
        return -1; // No match found
    }

    public static void main(String args[]){
        System.out.println(rabinKarpAlgo("apoorvkunalr", "kunal"));
    }
}
