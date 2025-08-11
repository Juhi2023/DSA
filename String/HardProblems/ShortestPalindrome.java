class ShortestPalindrome{

    //Using Rabin Karp : calculating reverse hash also
    //Time COmplexity: O(N)
    //Space Complexity: O(N)
    public static String shortestPalindromeByRK(String s) {
        long mod=(long)1e9+7;
        long base=29;
        long forwardHash=0;
        long reverseHash=0;
        long powerValue = 1;
        int index=-1;
        for(int i=0; i<s.length(); i++){
            char  c = s.charAt(i);
            forwardHash = (forwardHash * base + (c-'a')) %mod;
            reverseHash = (reverseHash + (c - 'a') * powerValue) % mod;
            powerValue = (powerValue * base) % mod;

            if(forwardHash==reverseHash){
                index=i;
            }
        }

        StringBuilder addition = new StringBuilder(s.substring(index+1));
        addition.reverse();
        return addition.toString()+s;
    }

    //Using KMP
    //Time COmplexity: O(N)
    //Space Complexity: O(N)
    public static int[] LSP(String s){
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
        return lsp;
    }

    public static String shortestPalindromeByKMP(String s) {
        StringBuilder temp = new StringBuilder(s);
        temp.reverse();
        int lsp[] = LSP(s+"$"+temp);

        return temp.substring(0, temp.length() - lsp[lsp.length-1])+s;
    }



    public static void main(String args[]){
        System.out.println(shortestPalindromeByRK("aacecaaa"));
    }
}