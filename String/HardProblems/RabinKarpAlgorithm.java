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


    public static void main(String args[]){
        System.out.println(findSubstring("apoorvkunalr", "kunal"));
    }
}
