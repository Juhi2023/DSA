class KMPAlgorithm {

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

    public static boolean KMPSearch(String txt, String pattern){
        int[] lsp = LSP(pattern);
        int n= pattern.length();
        int first=0, second=0;
        while(second<n && first< txt.length()){
            if(pattern.charAt(second)==txt.charAt(first)){
                second++;
                first++;
            }else{
                if(second==0){
                    first++;
                }else{
                    second=lsp[second-1];
                }
            }
        }
        return second==n;
    }
    
    
    public static void main(String args[]) {
        System.out.println(KMPSearch("onionionson", "onions"));
        
    }
}