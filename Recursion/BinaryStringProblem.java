class BinaryStringProblem{
    
    public static void printSubstrings  (int n, int last, String str){
        if(n==0){
            System.out.println(str);
            return;
        }

        if(last==0)
            printSubstrings(n-1, 1, str+"1");

        printSubstrings(n-1, 0, str+"0");
    }

    public static void main(String []args){
        printSubstrings(3, 0, "");
    }
}