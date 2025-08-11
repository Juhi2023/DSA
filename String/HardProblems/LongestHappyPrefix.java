class LongestHappyPrefix {

    //Using KMP
    //Time COmplexity: O(N)
    //Space Complexity: O(N)
    public static int LSP(String s){
        int[] lsp = new int[s.length()];
        int pre=0;
        int suf=1;
        while(suf<s.length()){
            if(s.charAt(pre)==s.charAt(suf)){
                lsp[suf]=pre+1;
                pre++;
                suf++;
            }else{
                if(pre==0){
                    lsp[suf]=0;
                    suf++;
                }else{
                    pre=lsp[pre-1];
                }
            }
        }
        return lsp[s.length()-1];
    }

    public static String longestPrefix(String s) {
        int length = LSP(s);
        return s.substring(0, length);
    }

    //Using Rabin Karp : calculating reverse hash also
    //Time COmplexity: O(N)
    //Space Complexity: O(N)
    static final long mod = 1_000_000_009L;
    static final long base = 31L;

    public static String longestPrefixByRK(String s) {
        int n = s.length();

        long ind = 0;
        long pref = 0, suff = 0, mult = 1;

        for (int i = 0; i < n - 1; i++) {
            pref = (pref + ((s.charAt(i) - 'a') * mult) % mod) % mod;
            suff = ((s.charAt(n - 1 - i) - 'a') + (suff * base) % mod) % mod;
            mult = (mult * base) % mod;

            if (suff == pref) {
                ind = n - 1 - i;
            }
        }

        if (ind > 0) {
            return s.substring((int) ind);
        }
        return "";
    }

    public static void main(String args[]) {
        System.out.println(longestPrefixByRK("level"));
        
    }
}