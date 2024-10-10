class BinaryStringProblem.java{
    
    public static void printSubstrings  (String s, String ans, int index){
        if(s.length()==index){
            System.out.println(ans);
            return;
        }

        char c = s.charAt(index);
        printSubstrings(s, ans+c, index+1);
        printSubstrings(s, ans, index+1);
    }

    public static void main(String []args){
        printSubstrings("ABC", "", 0);
    }
}