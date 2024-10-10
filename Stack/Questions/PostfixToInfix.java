import java.util.*;
class PostfixToInfixConversion{

    public static String postfixToInfix (String s){
        Stack<String> st = new Stack<>();
        String ans="";
        
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(c+"");
            }else{
                String a = st.pop();
                String b = st.pop();
                st.push("("+b+c+a+")");
            }
        }

        return st.pop();
    }

    public static void main(String args[]){
        String str = "AB+y-C*D-FZs^^+";
        
        System.out.println(postfixToInfix(str));
    }
}