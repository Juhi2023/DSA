public class LongestPalindrome{

    public static int getLength(String s) {
        int [] count = new int[58];
       int length=0;
       for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                count[s.charAt(i)-'a']++;
            }else{
               count[s.charAt(i)-'A'+26]++; 
            }
       }

       for(int c : count){
            length += ((c%2 == 0) ? c : c-1);
       }
       return s.length()>length ? length+1 : length;

    }



    public static void main(String [] args){
        System.out.println(getLength("abcdccca"));
    }
}