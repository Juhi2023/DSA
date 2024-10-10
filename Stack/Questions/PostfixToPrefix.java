import java.util.*;
class PostfixToPrefixConversion{

    public static String postfixToPrefix (String s){
        Stack<String> st = new Stack<>();
        String ans="";
        
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(c+"");
            }else{
                String a = st.pop();
                String b = st.pop();
                st.push(c+b+a);
            }
        }

        return st.pop();
    }

    public static void main(String args[]){
        String str = "AB+y-C*D-FZs^^+";
        
        System.out.println(postfixToPrefix(str));
    }
}